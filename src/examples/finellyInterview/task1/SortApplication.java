package examples.finellyInterview.task1;

import java.util.*;

public class SortApplication {

    private static User[][] users = {
            {new User("Andrii", 22)},
            {new User("Andrew", 27), new User("Andrew", 25)},
            {new User("Andrew", 24), new User("Andrew", 21), new User("Andrii", 21), new User("Andrei", 30)},
            {new User("Andrew", 21)}
    };

    /**
     * The method compares two User objects by name and age.
     *
     * @param userFirst  compared object of type {@code User}
     * @param userSecond compared object of type {@code User}
     * @return true if the first object is greater than the second, otherwise false.
     */
    private static Boolean isGreater(User userFirst, User userSecond) {
        return userFirst.compareTo(userSecond) > 0;
    }

    /**
     * Prints the contents of a two-dimensional array to the console.
     *
     * @param users two-dimensional array.
     */
    private static void printArrayToConsole(User[][] users) {
        for (int i = 0; i < users.length; i++) {
            System.out.println(Arrays.toString(users[i]));
        }
        System.out.println();
    }

    /**
     * In a two-dimensional array, sorts each one-dimensional array of the User type.
     *
     * @param mass a two-dimensional array in which the one-dimensional array must be sorted.
     * @return two-dimensional array with sorted one-dimensional arrays of the User type.
     */
    private static User[][] sortingLinesMass(User[][] mass) {
        for (int i = 0; i < mass.length; i++) {
            User[] temp = mass[i].clone();
            Arrays.sort(temp);
            mass[i] = temp.clone();
        }
        return mass;
    }

    /**
     * Sorts a two-dimensional array User between lines.
     *
     * @param mass a two-dimensional array in which the one-dimensional array must be sorted.
     * @return a sorted two-dimensional array of User between the lines.
     */
    private static User[][] sortingBetweenLinesMass(User[][] mass) {
        int lengthMass = mass.length;
        if (lengthMass > 1) {
            for (int i = 0; i < lengthMass; i++) {
                for (int j = lengthMass - 1; j > 0; j--) {
                    for (int l = 0; l < j; l++) {
                        int lengthFirst = mass[l].length;
                        int lengthSecond = mass[l + 1].length;
                        int minLengthMass = Math.min(lengthFirst, lengthSecond);
                        for (int m = 0; m < minLengthMass; m++) {
                            User user1 = mass[l][m];
                            User user2 = mass[l + 1][m];
                            if (isGreater(user1, user2)) {
                                User[] buff = mass[l];
                                mass[l] = mass[l + 1];
                                mass[l + 1] = buff;
                            }
                        }
                    }
                }
            }
        }
        return mass;
    }

    public static void main(String[] args) {

        System.out.print("Source array:\n");
        printArrayToConsole(users);

        users = sortingLinesMass(users);
        System.out.println("Sorting in lines:");
        printArrayToConsole(users);

        users = sortingBetweenLinesMass(users);
        System.out.println("Sorting between lines:");
        printArrayToConsole(users);
    }
}
