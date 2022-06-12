import java.lang.reflect.Array;

public class ArrayDeque {
    private int size;
    private int length=8;
    public int head=3;
    public int tail=3;
    public  int l[];
    /*build new ArrayDeque*/
    public ArrayDeque(){
        l=new int[length];
        size=0;
    }
    /*check if size>length, if so resize size*/
    public void checksize(){
        if (size==length){
            resize(length*2);
        }
    }
    /* resize the array if size not enough*/
    public void resize(int length){
        int[] a=new int[length];
        System.arraycopy(l,0,a,0,size);
        l=a;
        /* bruh this step is just jenius*/
        head=length-1;
        tail=size;

    }
    /*add first, head node step one block forward every time*/
    public void addFirst(int x){
        l[head]=x;
        if(head==0){
            head=length-1;
        }else{
            head--;
        }
        size++;
        checksize();
    }
    /*add last, tail node step one block backward every time*/
    public void addLast(int x){
        l[tail]=x;
        if(tail==length-1){
            tail=0;
        }else{
            tail++;
        }
        size++;
        checksize();
    }

    public void removeFirst(){

    }
}
