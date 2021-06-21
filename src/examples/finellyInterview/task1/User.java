package examples.finellyInterview.task1;

import java.util.Objects;

/**
 * The class describes the user with the fields name and age.
 *
 * @author Kiryl_Vinakurau
 */
public class User implements Comparable<User>{
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object comparedUser) {
        if (this == comparedUser) return true;
        if (comparedUser == null || getClass() != comparedUser.getClass()) return false;
        User user = (User) comparedUser;
        return Objects.equals(name, user.name) && Objects.equals(age, user.age);
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
        if (user.getAge() <= 0 || user.getAge() == null) {
            System.out.println("User age <= 0 or null.");
            throw new NullPointerException();
        }
        int userNameCompare = name.compareTo(user.getName());
        if (userNameCompare != 0) {
            return userNameCompare;
        }
        int userAgeCompare = age.compareTo(user.getAge());
        if (userAgeCompare != 0) {
            return userAgeCompare;
        }
        return 0;
    }
}
