package practice5.task2_TestCrazyCalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CalculatorNegativeTest {

    private Calculator calculator;
    private int maxInt = Integer.MAX_VALUE;
    private int minInt = Integer.MIN_VALUE;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testAdditionIntThenOverflow() {
        assertTrue("The addition of ints incorrectly goes beyond the limit.",
                calculator.addition(1, maxInt) == minInt &&
                calculator.addition(-1, minInt) == maxInt);
    }

    @Test
    public void testSubtractionIntThenOverflow() {
        assertTrue("The subtraction of ints incorrectly goes beyond the limit.",
                calculator.subtraction(maxInt, -1) == minInt &&
                calculator.subtraction(minInt, 1) == maxInt);
    }

    @Test
    public void testMultiplicationIntThenOverflow() {
        assertTrue("The multiplication of ints incorrectly goes beyond the limit.",
                (calculator.multiplication(1, maxInt) + 1) == minInt
                        && (calculator.multiplication(1, minInt) - 1) == maxInt);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionIntByZero() {
        calculator.division(13, 0);
    }

    @Test
    public void testDivisionDoubleByZero() {
        assertTrue("Dividing a double variable by zero is not infinite.",
                 Double.isInfinite(calculator.division(13.13, 0.0)));
    }

    @Test
    public void testRootIntMinusOne() {
        assertTrue("Square root of -1 not NAN", Double.isNaN(calculator.root(-1)));
    }

    @Test
    public void testRootDoubleMinusOne() {
        assertTrue("Square root of -1.0 not NAN", Double.isNaN(calculator.root(-1.0)));
    }

    @Test(timeout = 3_000)
    public void testIsPrime() {
        assertTrue("The number is not prime.", calculator.isPrime(556289));
    }

    @Test
    public void testFibonacciSequence() {
        long[] array = {1, 1, 2, 3, 5, 8};
        assertThat(array, is(equalTo(calculator.FibonacciSequence(6))));
    }
}