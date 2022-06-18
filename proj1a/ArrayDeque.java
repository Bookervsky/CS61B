import java.lang.reflect.Array;

public class ArrayDeque<T> {
    private int size;
    private int length=8;
    private int head=3;
    private int tail=3;

    private T[] l;
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
        for(int i=0;i<size;i++){
            a[i]=l[(head+1+i)%length];
        }
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

    public T removeFirst(){
        T x=l[(head+1)%length];
        if(head==length-1){
            head=0;
        }else {
            head++;
              }
        size--;
        checksizesmall();
        return x;
        }
    public T removeLast(){
        T x=l[(head+size)%length];
        if(tail==0){
            tail=size-1;
        }else{
            size++;
        }
        size--;
        checksizesmall();
        return x;
    }


    public T get(int index){
        if(index>size){
            return null;
        }
        /*???这谁想得出来？？？？？？？*/
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
        for(int i=15;i>=1;i--){
            l.addFirst(i);
        }
        for(int i=16;i<=36;i++){
            l.addLast(i);
        }
        l.addFirst(0);
        l.printDeque();
        T x=l.get(30);
    }
    */
}
