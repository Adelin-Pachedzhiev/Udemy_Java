import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RemovePairsTest {

    private Utilities util;
    private String expected;
    private String result;

    public RemovePairsTest(String expected, String result) {
        this.expected = expected;
        this.result = result;
    }

    @Before
    public void setUp() throws Exception {
        util = new Utilities();
    }

    @Parameterized.Parameters
    public static Collection<Object> params(){
        return Arrays.asList(new Object[][]{
                {"ABCABDEF", "ABCCABDEEF"},
                {"H","H"},
                {null, null}

        });
    }

    @Test
    public void removePairs2() {
        assertEquals(expected, util.removePairs(result));
    }

}
