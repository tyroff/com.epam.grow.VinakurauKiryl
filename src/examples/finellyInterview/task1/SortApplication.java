package examples.finellyInterview.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortApplication {

    public static User[][] users = {
            {new User("Andrii", 22)},
            {new User("Andrew", 27), new User("Andrew", 25)},
            {new User("Andrew", 24), new User("Andrew", 21), new User("Andrii", 21), new User("Andrei", 30)},
            {new User("Andrew", 21)}
    };

    /**
     * Sorts the User List by name and age.
     *
     * @param userList sorted {@code List}
     */
    private static void order(List<User> userList) {
        Collections.sort(userList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String nameUser1 = ((User) o1).getName();
                String nameUser2 = ((User) o2).getName();
                if (nameUser1.isBlank() || nameUser2.isBlank()) throw new NullPointerException();
                int userCompare = nameUser1.compareTo(nameUser2);
                if (userCompare != 0) {
                    return userCompare;
                }
                Integer ageUser1 = ((User) o1).getAge();
                Integer ageUser2 = ((User) o2).getAge();
                return ageUser1.compareTo(ageUser2);
            }
        });
    }

    /**
     * The method compares two User objects by name and age.
     *
     * @param userFirst compared object of type {@code User}
     * @param userSecond compared object of type {@code User}
     * @return true if the first object is greater than the second, otherwise false.
     */
    private static Boolean orderByUsers(User userFirst, User userSecond) {
        String nameUserFirst = userFirst.getName();
        String nameUserSecond = userSecond.getName();
        if (nameUserFirst.compareTo(nameUserSecond) > 0) {
            return true;
        }
        if (nameUserFirst.compareTo(nameUserSecond) == 0) {
            if (userFirst.getAge() > userSecond.getAge()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.print("Source array:\n");
        for (int i = 0; i < users.length; i++) {
            for (int j = 0; j < users[i].length; j++) {
                System.out.print(users[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        //Sorting in each line.
        User[][] sortMass = new User[users.length][];
        List<User> buffList = new ArrayList<>();
        for (int i = 0; i < users.length; i++) {
            for (int j = 0; j < users[i].length; j++) {
                buffList.add(users[i][j]);
            }
            order(buffList);
            User[] masUserBuff = new User[buffList.size()];
            for (int k = 0; k < buffList.size(); k++) {
                masUserBuff[k] = buffList.get(k);
            }
            sortMass[i] = masUserBuff;
            buffList.removeAll(buffList);
        }
        System.out.println("Sorting in lines:");
        for (int i = 0; i < sortMass.length; i++) {
            for (int j = 0; j < sortMass[i].length; j++) {
                System.out.print(sortMass[i][j] + "\t");
            }
            System.out.println();
        }

        //Sorting lines.
        int lengthSortLines = sortMass.length;
        for (int i = 0; i < lengthSortLines; i++) {
            if (lengthSortLines == 1) {
                for (int j = 0; j < sortMass[0].length; j++) {
                    System.out.print(sortMass[0][j] + "\t");
                }
                System.out.println();
            } else if (lengthSortLines > 1) {
                for (int k = lengthSortLines - 1; k >0; k--) {
                    for (int l = 0; l < k; l++) {
                        int lengthFirst = sortMass[l].length;
                        int lengthSecond = sortMass[l + 1].length;
                        if (lengthFirst <= lengthSecond) {
                            for (int m = 0; m < lengthFirst; m++) {
                                User user1 = sortMass[l][m];
                                User user2 = sortMass[l + 1][m];
                                if (orderByUsers(user1, user2)) {
                                    User[] buff = sortMass[l];
                                    sortMass[l] = sortMass[l + 1];
                                    sortMass[l + 1] = buff;
                                }
                            }
                        } else {
                            for (int m = 0; m < lengthSecond; m++) {
                                User user1 = sortMass[l][m];
                                User user2 = sortMass[l + 1][m];
                                if (orderByUsers(user1, user2)) {
                                    User[] buff = sortMass[l];
                                    sortMass[l] = sortMass[l + 1];
                                    sortMass[l + 1] = buff;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("\nSorting between lines:");
        for (int i = 0; i < sortMass.length; i++) {
            for (int j = 0; j < sortMass[i].length; j++) {
                System.out.print(sortMass[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
