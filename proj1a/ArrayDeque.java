import java.lang.reflect.Array;

public class ArrayDeque<T> {
    private int size;
    private int length=8;
    public int head=3;
    public int tail=3;

    public T[] l;
    /*build new ArrayDeque*/
    public ArrayDeque(){
        l=(T[]) new Object[length];
        size=0;
    }
    public boolean isEmpty(){
        return size==0;
    }
    /*check if size>length, if so resize size*/
    public void checksizelarge(){
        if (size==length){
            resize(length*2);
            length=length*2;
        }
    }
    public void checksizesmall(){
        if(length>=16&&size/length<0.25){
            length=length/2;
        }
    }
    public int size(){
        return size;
    }
    /* resize the array if size not enough*/
    public void resize(int x){
        T[] a=(T[]) new Object[x];
        System.arraycopy(l,0,a,0,size);
        l=a;
        /* bruh this step is just genius*/
        head=x-1;
        tail=size;

    }


    /*add first, head node step one block forward every time*/
    public void addFirst(T x){
        l[head]=x;
        if(head==0){
            head=length-1;
        }else{
            head--;
        }
        size++;
        checksizelarge();
    }
    /*add last, tail node step one block backward every time*/
    public void addLast(T x){
        l[tail]=x;
        if(tail==length-1){
            tail=0;
        }else{
            tail++;
        }
        size++;
        checksizelarge();
    }

    public void removeFirst(){
        if(head==size-1||(head==length-1&&size==length/2)){
            head=0;
        }else {
            head++;
              }
        size--;
        checksizesmall();
        }
    public void removeLast(){
        if(tail==0||tail==size){
            tail=size-1;
        }else{
            size++;
        }
        size--;
        checksizesmall();
    }

    public T get(int index){
        /*???这谁想得出来？？？？？？？*/
        if(index>size){
            return null;
        }
        return l[(head+1+index)%length];
    }
    public void printDeque(){
        int i=0;
        while(i<size){
            System.out.print(l[(head+1+i)%length]+" ");
            i++;
        }
        System.out.println();
    }
    /*
    public static void main(String[] args){
        ArrayDeque<Integer> l= new ArrayDeque<>();
        for(int i=0;i<=16;i++){
            l.addFirst(i);
        }
        for(int i=17;i<=20;i++){
            l.addLast(i);
        }
        l.printDeque();
    }
     */
}
