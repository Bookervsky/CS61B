public class LinkedListDeque <T>{
    /*create Node class  */
    public class Node{
        public Node prev;
        public T item;
        public Node next;

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

    public  LinkedListDeque(T x) {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /* 1.2.add first and add last method */
    public void addFirst(T x) {
        sentinel.next = new Node(sentinel, x, sentinel.next);
        size += 1;
    }
    public void addLast(T x) {
        sentinel.prev = new Node(sentinel.next, x, sentinel);
        size += 1;
    }
    /* 6.7remove first and remove last method */
    public Object removeFirst(){
        if(size==0){
            return null;
        }
        T x;
        x=sentinel.next.item;
        sentinel.next=sentinel.next.next;
        size-=1;
        return x;
    }
    public Object removeLast(){
        if(size==0){
            return null;
        }
        T x;
        x=sentinel.prev.item;
        sentinel.prev=sentinel.prev.prev;
        return x;
    }
    /*  3. return empty  */
    public boolean isEmpty() {
        if (sentinel.next == null) {
            return true;
        } else {
            return false;
        }
    }
    public int size(){
        return size;
    }

    public void printDeque(LinkedListDeque x){
        if(size==0){
            System.out.printf(null);
        }
        Node p=sentinel;
        while(p.next!=sentinel){
            System.out.print(p.item+" ");
        }
        System.out.println();
    }
    public T get(int index){
        if(size==0){
            return null;
        }
        int i=0;
        Node p=sentinel.next;
        while(i<index){
            p=p.next;
            i++;
        }
        return p.item;
    }

}
