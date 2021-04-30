package practice5.task2_TestCrazyCalculator;

import org.junit.*;
import practice5.task2_TestCrazyCalculator.Calculator;

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

    @Test(expected = IllegalArgumentException.class)
    public void testAdditionIntThenOverflow() {
        if (calculator.addition(1, maxInt) > maxInt &&
        calculator.addition(-1, minInt) < minInt) {
            throw new IllegalArgumentException("Overflow Int value when addition.");
        };
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractionIntThenOverflow() {
        if (calculator.subtraction(maxInt, -1) > maxInt &&
                calculator.subtraction(minInt, 1) < minInt) {
            throw new IllegalArgumentException("Overflow Int value when subtraction.");
        };
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplicationIntThenOverflow() {
        if (calculator.multiplication(1, maxInt) + 1 > maxInt ||
        calculator.multiplication(1, maxInt) - 1 < minInt) {
            throw new IllegalArgumentException("Overflow Int value when multiplication");
        }
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionIntByZero() {
        calculator.division(13, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionDoubleByZero() {
        calculator.division(13.13, 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void testRootIntMinusOne() {
        calculator.root(-1);
    }

    @Test(expected = ArithmeticException.class)
    public void testRootDoubleMinusOne() {
        calculator.root(-1.0);
    }
}