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
        if (userFirst.compareTo(userSecond) > 0) {
            return true;
        }
        return false;
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

    public static void main(String[] args) {

        System.out.print("Source array:\n");
        printArrayToConsole(users);

        //Sorting in each line.
        User[][] sortMass = new User[users.length][];
        for (int i = 0; i < users.length; i++) {
            User[] temp = users[i].clone();
            Arrays.sort(temp);
            sortMass[i] = temp.clone();
        }
        System.out.println("Sorting in lines:");
        printArrayToConsole(sortMass);

        //Sorting lines.
        int lengthSortLines = sortMass.length;
        for (int i = 0; i < lengthSortLines; i++) {
            if (lengthSortLines == 1) {
                Arrays.toString(sortMass);
            } else if (lengthSortLines > 1) {
                for (int j = lengthSortLines - 1; j > 0; j--) {
                    for (int l = 0; l < j; l++) {
                        int lengthFirst = sortMass[l].length;
                        int lengthSecond = sortMass[l + 1].length;
                        int minLengthMass = lengthFirst <= lengthSecond ? lengthFirst : lengthSecond;
                        for (int m = 0; m < minLengthMass; m++) {
                            User user1 = sortMass[l][m];
                            User user2 = sortMass[l + 1][m];
                            if (isGreater(user1, user2)) {
                                User[] buff = sortMass[l];
                                sortMass[l] = sortMass[l + 1];
                                sortMass[l + 1] = buff;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("\nSorting between lines:");
        printArrayToConsole(sortMass);
    }
}
