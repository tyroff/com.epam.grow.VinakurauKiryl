package practice5.task2_TestCrazyCalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class CalculatorNegativeTest {

    int maxInt = Integer.MAX_VALUE;
    int minInt = Integer.MIN_VALUE;

    @Test(expected = IllegalArgumentException.class)
    void testAdditionIntThenOverflow() {
        if (Calculator.addition(1, maxInt) > maxInt &&
        Calculator.addition(-1, minInt) < minInt) {
            throw new IllegalArgumentException("Overflow Int value when addition.");
        };
    }

    @Test(expected = IllegalArgumentException.class)
    void testSubtractionIntThenOverflow() {
        if (Calculator.subtraction(maxInt, -1) > maxInt &&
                Calculator.subtraction(minInt, 1) < minInt) {
            throw new IllegalArgumentException("Overflow Int value when subtraction.");
        };
    }

    @Test(expected = IllegalArgumentException.class)
    void testMultiplicationIntThenOverflow() {
        if (Calculator.multiplication(1, maxInt) + 1 > maxInt ||
        Calculator.multiplication(1, maxInt) - 1 < minInt) {
            throw new IllegalArgumentException("Overflow Int value when multiplication");
        }
    }

    @Test(expected = IllegalArgumentException.class)
    void testDivisionIntByZero() {
        Calculator.division(13, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    void testDivisionDoubleByZero() {
        Calculator.division(13.13, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    void testRootIntMinusOne() {
        Calculator.root(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    void testRootDoubleMinusOne() {
        Calculator.root(-1.0);
    }
}