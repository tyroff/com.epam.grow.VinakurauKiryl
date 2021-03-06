package practice5.task2_TestCrazyCalculator;

/**
 * Performs the following operations on integer and double numbers: addition, subtraction, multiplication, division,
 * root / power function.
 *
 * @author Kiryl_Vinakurau
 */
public class Calculator {

    /**
     * Adds two numbers of type {@code int}.
     *
     * @param i1 number type int.
     * @param i2 number type int.
     * @return addition of two numbers of type int.
     */
    public int addition(int i1, int i2) {
        return i1 + i2;
    }

    /**
     * Adds two numbers of type {@code double}.
     *
     * @param i1 number type double.
     * @param i2 number type double.
     * @return addition of two numbers of type double.
     */
    public double addition(double i1, double i2) {
        return i1 + i2;
    }

    /**
     * Subtraction two numbers of type {@code int}.
     *
     * @param i1 number type double.
     * @param i2 number type double.
     * @return subtraction of two numbers of type double.
     */
    public int subtraction(int i1, int i2) {
        return i1 - i2;
    }

    /**
     * Subtraction two numbers of type {@code double}.
     *
     * @param i1 number type double.
     * @param i2 number type double.
     * @return subtraction of two numbers of type double.
     */
    public double subtraction(double i1, double i2) {
        return i1 - i2;
    }

    /**
     * Multiplication two numbers of type {@code int}.
     *
     * @param i1 number type int.
     * @param i2 number type int.
     * @return multiplication of two numbers of type int.
     */
    public int multiplication(int i1, int i2) {
        return i1 * i2;
    }

    /**
     * Multiplication two numbers of type {@code double}.
     *
     * @param i1 number type double.
     * @param i2 number type double.
     * @return multiplication of two numbers of type double.
     */
    public double multiplication(double i1, double i2) {
        return i1 * i2;
    }

    /**
     * Division two numbers of type {@code int}.
     *
     * @param i1 number type int.
     * @param i2 number type int.
     * @return division of two numbers of type int.
     */
    public double division(int i1, int i2) {
        return i1 / i2;
    }

    /**
     * Division two numbers of type {@code double}.
     *
     * @param i1 number type double.
     * @param i2 number type double.
     * @return division of two numbers of type double.
     */
    public double division(double i1, double i2) {
        return i1 / i2;
    }

    /**
     * Root number of type {@code int}.
     *
     * @param i1 number type int.
     * @return root number of type int.
     */
    public double root(int i1) {
        return Math.sqrt(i1);
    }

    /**
     * Root number of type {@code double}.
     *
     * @param i1 number type double.
     * @return root number of type double.
     */
    public double root(double i1) {
        return Math.sqrt(i1);
    }

    /**
     * Power function number of type {@code int}.
     *
     * @param i1       number type int.
     * @param powValue power type int.
     * @return root number of type int.
     */
    public double pow(int i1, int powValue) {
        return Math.pow(i1, powValue);
    }

    /**
     * Power function number of type {@code double}.
     *
     * @param i1       number type double.
     * @param powValue power type int.
     * @return root number of type double.
     */
    public double pow(double i1, int powValue) {
        return Math.pow(i1, powValue);
    }

    /**
     * If the number is prime it returns True otherwise False.
     *
     * @param i checked number.
     * @return if the number is prime it returns True otherwise False.
     */
    public boolean isPrime(int i) {
        if (i <= 1) {
            return false;
        }
        for (int j = 2; j < i; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }

    /**
     * Displays the Fibonacci sequence.
     *
     * @param i the number of members of the Fibonacci sequence.
     */
    public long[] FibonacciSequence(int i) {
        if (i < 1) {
            throw new IllegalArgumentException();
        }

        long[] array = new long[i];
        if (i == 1) {
            array[0] = 1;
        } else if (i == 2) {
            array[0] = 1;
            array[1] = 1;
        } else if (i > 2) {
            array[0] = 1;
            array[1] = 1;
            long i1 = 1;
            long i2 = 1;
            long sum;
            for (int j = 2; j < i; j++) {
                sum = i1 + i2;
                array[j] = sum;
                i1 = i2;
                i2 = sum;
            }
        }
        return array;
    }
}
