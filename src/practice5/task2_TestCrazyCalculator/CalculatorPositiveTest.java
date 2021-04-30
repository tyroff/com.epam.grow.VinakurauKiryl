package practice5.task2_TestCrazyCalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorPositiveTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testAdditionInt() {
        assertEquals(13, calculator.addition(1, 12));
    }

    @Test
    public void testAdditionDouble() {
        assertEquals(13.13, calculator.addition(13.0, 0.13), 0.00);
    }

    @Test
    public void testSubtractionInt() {
        assertEquals(13, calculator.subtraction(14, 1));
    }

    @Test
    public void testSubtractionDouble() {
        assertEquals(13.13, calculator.subtraction(14.0, 0.87), 0.00);
    }

    @Test
    public void testMultiplicationInt() {
        assertEquals(12, calculator.multiplication(2, 6));
    }

    @Test
    public void testMultiplicationDouble() {
        assertEquals(9.680000000000001, calculator.multiplication(2.2, 4.4), 0.00);
    }

    @Test
    public void testDivisionInt() {
        assertEquals(2, calculator.division(8, 4), 0);
    }

    @Test
    public void testDivisionDouble() {
        assertEquals(5.968181818181818, calculator.division(13.13, 2.2), 0.000);
    }

    @Test
    public void testRootInt() {
        assertEquals(13, calculator.root(169), 0);
    }

    @Test
    public void testRootDouble() {
        assertEquals(13.129999999999999, calculator.root(172.3969), 0.00);
    }

    @Test
    public void testPowInt() {
        assertEquals(169, calculator.pow(13, 2), 0);
    }

    @Test
    public void testPowDouble() {
        assertEquals(2248.091, calculator.pow(13.1, 3), 0.000);
    }
}