import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    @Test
    public void testA(){
        StudentArrayDeque<Integer> s1 = new StudentArrayDeque<>();
        s1.addFirst(StdRandom.uniform(9));
        s1.addFirst(StdRandom.uniform(9));
        s1.removeLast();
        ArrayDequeSolution<Integer> s2 = new ArrayDequeSolution<>();
        s2.addFirst(StdRandom.uniform(9));
        s2.addLast(StdRandom.uniform(9));
        s2.removeFirst();
        assertEquals(s1.get(0),s2.getRecursive(0));
    }
}
