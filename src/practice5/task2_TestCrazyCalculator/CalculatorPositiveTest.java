package practice5.task2_TestCrazyCalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class CalculatorPositiveTest {

    @Test
    void testAdditionInt() {
        assertEquals(13, Calculator.addition(1, 12));
    }

    @Test
    void testAdditionDouble() {
        assertEquals(13.13, Calculator.addition(13.0, 0.13), 0.00);
    }

    @Test
    void testSubtractionInt() {
        assertEquals(13, Calculator.subtraction(14, 1));
    }

    @Test
    void testSubtractionDouble() {
        assertEquals(13.13, Calculator.subtraction(14.0, 0.87), 0.00);
    }

    @Test
    void testMultiplicationInt() {
        assertEquals(12, Calculator.multiplication(2, 6));
    }

    @Test
    void testMultiplicationDouble() {
        assertEquals(9.68, Calculator.multiplication(2.2, 4.4), 0.00);
    }

    @Test
    void testDivisionInt() {
        assertEquals(2, Calculator.division(8, 4));
    }

    @Test
    void testDivisionDouble() {
        assertEquals(28.886, Calculator.division(13.13, 2.2), 0.000);
    }

    @Test
    void testRootInt() {
        assertEquals(13, Calculator.root(169), 0);
    }

    @Test
    void testRootDouble() {
        assertEquals(13.13, Calculator.root(172.3969), 0.00);
    }

    @Test
    void testPowInt() {
        assertEquals(169, Calculator.pow(13, 2), 0);
    }

    @Test
    void testPowDouble() {
        assertEquals(2248.091, Calculator.pow(13.1, 3), 0.000);
    }
}