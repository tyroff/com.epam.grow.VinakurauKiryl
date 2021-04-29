package practice5.task1_GuessAboutFunctionality;

/**
 * @author Kiryl_Vinakurau
 */
public class Utils {

    /**
     * Concatenates two variables of type String.
     *
     * @param s1 variable of type String.
     * @param s2 variable of type String.
     * @return concatenate {@code s1 + s2}.
     */
    public String concatenateWords(String s1, String s2) {
        if (s1.isEmpty() || s1.isBlank() || s2.isEmpty() || s2.isBlank()) {
            throw new IllegalArgumentException();
        } else {
            return s1 + s2;
        }
    }

    /**
     * Calculates the factorial of a number.
     *
     * @param i the number for which you want to find the factorial.
     * @return factorial of a number.
     */
    public int computeFactorial(int i) {
        int result = 0;
        for (int j = 1; j - 1 < i; j++) {
            if (j == 1) result = 1;
            else result *= j;
        }
        return result;
    }
}
