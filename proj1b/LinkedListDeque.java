public class LinkedListDeque<T> implements Deque<T> {
    /*create Node class  */
    private class Node{
        private Node prev;
        private T item;
        private Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private int size=0;
    /*   create  sentinel Node  */
    private Node sentinel;

    /*create class LinkedListDeque*/
    public  LinkedListDeque() {
        sentinel = new Node(null, null, null);
    }
    /**
     public  LinkedListDeque(T x) {
     sentinel = new Node(null, null, null);
     sentinel.next = new Node(sentinel, x, sentinel);
     sentinel.prev = sentinel.next;
     size = 1;
     }
     */
    @Override
    /* 1.2.add first and add last method */
    public void addFirst(T x) {
        if(this.isEmpty()) {
            sentinel.next = new Node(sentinel, x, sentinel);
            sentinel.prev = sentinel.next;
        }
        else {
            Node newnode = new Node(sentinel, x, sentinel.next);
            sentinel.next.prev = newnode;
            sentinel.next = newnode;
        }
        size += 1;
    }
    @Override
    public void addLast(T x) {
        if(this.isEmpty()) {
            sentinel.next = new Node(sentinel, x, sentinel);
            sentinel.prev = sentinel.next;
        }
        else {
            Node newnode = new Node(sentinel.prev, x, sentinel);
            sentinel.prev.next = newnode;
            sentinel.prev = newnode;
        }
        size += 1;
    }
    @Override
    /* 6.7remove first and remove last method */
    public T removeFirst(){
        if(size==0){
            return null;
        }
        T x;
        x=sentinel.next.item;
        sentinel.next=sentinel.next.next;
        sentinel.next.prev=sentinel;
        size-=1;
        return x;
    }
    @Override
    public T removeLast(){
        if(size==0){
            return null;
        }
        T x;
        x=sentinel.prev.item;
        sentinel.prev=sentinel.prev.prev;
        sentinel.prev.next=sentinel;
        size-=1;
        return x;
    }
    @Override
    /*  3. return empty  */
    public boolean isEmpty() {
        if (size==0) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        if(size==0){
            System.out.printf(null);
        }
        Node p=sentinel;
        while(p.next!=sentinel){
            System.out.print(p.item+" ");
            p=p.next;
        }
        System.out.println();
    }
    @Override
    public T get(int index){
        if(size==0||index>size){
            return null;
        }
        int i=0;
        Node p=sentinel;
        while(i<=index){
            p=p.next;
            i++;
        }
        return p.item;
    }

    private T recursiveHelper(Node p,int index) {
        if (index == 0) {
            return p.item;
        }
        return recursiveHelper(p.next,index - 1);
    }

    public T getRecursive(int index) {
        if(index > size) {
            return null;
        } else {
            return recursiveHelper(sentinel.next,index);
        }
    }
}
