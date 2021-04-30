package practice5.task1_GuessAboutFunctionality;

import org.junit.*;

import java.text.Normalizer;

import static org.junit.Assert.*;

public class TestUtils {

    private Utils utils;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before UtilsTest start");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After UtilsTest finished");
    }

    @Before
    public void initTest() {
        utils = new Utils();
    }

    @After
    public void afterTest() {
        utils = null;
    }

    @Test
    public void testConcatenateWords() {
        assertEquals("test1", utils.concatenateWords("test", "1"));
        System.out.println("+ Test testConcatenateWords() is completed");
    }

    @Test
    public void testComputeFactorial() {
        assertEquals(120, utils.computeFactorial(5));
        System.out.println("+ Test testComputeFactorial() is completed");
    }

    @Test(timeout = 200)
    public void testFactorialWithTimeout() {
        assertEquals(120, utils.computeFactorial(5));
        System.out.println("+ Test testFactorialWithTimeout() is completed");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExpectedException() {
        utils.computeFactorial(-5);
        System.out.println("+ Test testExpectedException() is completed");
    }

    @Ignore
    @Test
    public void testNormalizeWord() {
        System.out.println(Normalizer.normalize("NoRMalIZed teXt", Normalizer.Form.NFD));
        System.out.println("+ Test testNormalizeWord() isn't completed");
    }
}
