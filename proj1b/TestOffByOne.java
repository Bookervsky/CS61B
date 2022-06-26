import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.*/
    static CharacterComparator offByOne = new OffByOne();
    // Your tests go here.
    @Test
    public void testOffbyOne(){
        boolean a = offByOne.equalChars('a','b');
        boolean b = offByOne.equalChars('g','f');
        boolean c = offByOne.equalChars('s','y');
        boolean d = offByOne.equalChars('%','&');
        assertTrue(a);
        assertTrue(b);
        assertFalse(c);
        assertTrue(d);
    }
}
