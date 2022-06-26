public interface Deque<Item> {
    public void addFirst(Item x);
    public void addLast(Item x);
    public Item removeFirst();
    public Item removeLast();
    public Item get(int index);
    public void printDeque();
    public int size();
    default public boolean isEmpty(){
        if(size()==0){
            return true;
        }
        return false;
    }
}
