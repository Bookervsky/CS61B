import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void testOffByN(){
        boolean a = offByN.equalChars('a','f');
        assertTrue(a);
    }
}
