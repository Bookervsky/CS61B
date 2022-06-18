import java.lang.reflect.Array;

public class ArrayDeque<T> {
    private int size;
    private int length=8;
    private int head=3;
    private int tail=4;

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
    private void checksizelarge(){
        if (size==length){
            resize(length*2);
            length=length*2;
        }
    }
    private void checksizesmall(){
        /** u can't write  "size/length<0.25" here because they are both integer, u will get 0 instead of a decimal */
        if(length>=16&&length/size>4){
            resize(length/2);
            length=length/2;
        }
    }
    public int size(){
        return size;
    }
    /* resize the array if size not enough*/
    private void resize(int x){
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
        checksizelarge();
        l[head]=x;
        if(head==0){
            head=length-1;
        }else{
            head--;
        }
        size++;
    }
    /*add last, tail node step one block backward every time*/
    public void addLast(T x){
        checksizelarge();
        l[tail]=x;
        if(tail==length-1){
            tail=0;
        }else{
            tail++;
        }
        size++;
    }

    public T removeFirst(){
        if(size==0){
            return null;
        }
        checksizesmall();
        T x=l[(head+1)%length];
        if(head==length-1){
            head=0;
        }else {
            head++;
              }
        size--;
        return x;
        }
    public T removeLast(){
        if(size==0){
            return null;
        }
        checksizesmall();
        T x=l[(head+size)%length];
        if(tail==0){
            tail=length-1;
        }else{
            tail--;
        }
        size--;
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
    public static void main(String[] args) {
        ArrayDeque<Integer> l = new ArrayDeque<>();
        l.addFirst(0);
        l.get(0);
        l.removeFirst();
        l.addLast(3);
        l.get(0);
        l.addFirst(5);
        l.get(0);
        l.addLast(8);
        l.addLast(9);
        l.addFirst(10);
        l.addFirst(11);
        l.addLast(12);
        l.removeFirst();
        l.removeLast();
        l.removeFirst();
        l.removeLast();
        l.get(2);
        l.addLast(18);
        l.addLast(19);
        l.get(3);
        l.printDeque();
    }
     */
}
