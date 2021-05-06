package practice5.task1_GuessAboutFunctionality;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.text.Normalizer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestUtils {

    private Utils utils;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void beforeClass() {
    }

    @AfterClass
    public static void afterClass() {
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
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConcatenateWordsThenEmptyOrBlankTwoParameters() {
        assertEquals("Not empty", utils.concatenateWords("", ""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConcatenateWordsThenEmptyOrBlankFirstParameter() {
        assertEquals("Not empty", utils.concatenateWords("", "text"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConcatenateWordsThenEmptyOrBlankSecondParameter() {
        assertEquals("Not empty", utils.concatenateWords("text", ""));
    }

    @Test(expected = NullPointerException.class)
    public void testConcatenateWordsThenNullTwoParameters() {
        assertNull("Not null", utils.concatenateWords(null, null));
    }

    @Test(expected = NullPointerException.class)
    public void testConcatenateWordsThenNullFirstParameter() {
        assertNull("Not null", utils.concatenateWords(null, "text"));
    }

    @Test(expected = NullPointerException.class)
    public void testConcatenateWordsThenNullSecondParameter() {
        assertNull("Not null", utils.concatenateWords("text", null));
    }

    @Test(expected = NullPointerException.class)
    public void testConcatenateWordsThenNullFirstParameterAndEmpty() {
        assertNull("Not null", utils.concatenateWords(null, ""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConcatenateWordsThenNullSecondParameterAndEmpty() {
        assertNull("Not null", utils.concatenateWords("", null));
    }

    @Test
    public void testComputeFactorial() {
        assertEquals(120, utils.computeFactorial(5));
    }

    @Test(timeout = 200)
    public void testFactorialWithTimeout() {
        assertEquals(120, utils.computeFactorial(5));
    }

    @Test
    public void testExpectedException() {
        utils.computeFactorial(-5);
        thrown.expect(IllegalArgumentException.class);
        throw new IllegalArgumentException("What happened?");
    }

    @Ignore
    @Test
    public void testNormalizeWord() {
        System.out.println(Normalizer.normalize("NoRMalIZed teXt", Normalizer.Form.NFD));
    }
}
