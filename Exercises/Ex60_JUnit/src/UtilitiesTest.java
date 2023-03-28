import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class UtilitiesTest {
    private Utilities utilities;

    @Before
    public void setUp() throws Exception {
        utilities = new Utilities();
    }

    @Test
    public void everyNthChar() {
        char[] result = utilities.everyNthChar(new char[]{'h', 'e', 'l','l','o'}, 2);
        assertArrayEquals(new char[]{'e','l'}, result);
    }

    @Test
    public void everyNthChar1() {
        char[] result = utilities.everyNthChar(new char[]{'h', 'e', 'l','l','o'}, 6);
        assertArrayEquals(new char[]{'h','e','l','l','o'}, result);
    }

    @Test
    public void removePairs() {
        assertEquals("ABCABDEF", utilities.removePairs("ABCCABDEEF"));
    }

    @Test
    public void removePairs2() {
        assertEquals("H", utilities.removePairs("H"));
    }
    @Test
    public void removePairs3() {
        assertNull(utilities.removePairs(null));
    }

    @Test
    public void converter() {
        assertEquals(300, utilities.converter(10,5));
    }

    @Test(expected = ArithmeticException.class)
    public void converter1() {
        utilities.converter(10,0);
    }

    @Test
    public void nullIfOddLength() {
        assertNull(utilities.nullIfOddLength("cat"));
    }

    @Test
    public void nullIfOddLength1() {
        assertEquals("boat", utilities.nullIfOddLength("boat"));
    }
}