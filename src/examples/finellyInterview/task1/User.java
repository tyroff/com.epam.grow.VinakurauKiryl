package examples.finellyInterview.task1;

import java.util.Objects;

/**
 * The class describes the user with the fields name and age.
 *
 * @author Kiryl_Vinakurau
 */
public class User implements Comparable<User>{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(User user) {
        if (user.getName().isBlank() || user.getName() == null) {
            System.out.println("Name is blank or null");
            throw new NullPointerException();
        }
        if (user.getAge() <= 0) {
            System.out.println("User age <= 0");
            throw new NullPointerException();
        }
        int userCompare = name.compareTo(user.getName());
        if (userCompare != 0) {
            return userCompare;
        }
        if (age > user.getAge()) return 1;
        else if (age < user.getAge()) return -1;
        else return 0;
    }
}
