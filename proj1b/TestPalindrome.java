import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.*/
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testisPalindrome(){
        boolean t1 = palindrome.isPalindrome("abcdedcba");
        boolean t3 = palindrome.isPalindrome("aaaaaaaaaaaaaabaaaaaaaaaaaaaa");
        boolean t2 = palindrome.isPalindrome("coffee");
        assertTrue(t1);
        assertFalse(t2);
    }
    @Test
    public void TestisPalindrome(){
        CharacterComparator cc = new OffByOne();
        boolean a = palindrome.isPalindrome("flake",cc);
        boolean b = palindrome.isPalindrome("blade",cc);
        boolean c = palindrome.isPalindrome("abccb",cc);
        assertTrue(a);
        assertFalse(b);
        assertTrue(c);
    }
}
