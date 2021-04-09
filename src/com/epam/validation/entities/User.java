package com.epam.validation.entities;

import java.util.Objects;

/**
 * This class contains data about the user.
 *
 * @author Kiryl_Vinakurau
 */
public class User {
    private String name;
    private String surname;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Validates a field of a given class by its NAME and VALUE of type {@code byte}.
     *
     * @param name  field name.
     * @param value field value of type {@code byte}.
     * @return true if the field with the given name and given value meets the requirements specified in this
     * method.
     */
    public Boolean isValid(String name, byte value) {
        return true;
    }

    /**
     * Validates a field of a given class by its NAME and VALUE of type {@code short}.
     *
     * @param name  field name.
     * @param value field value of type {@code short}.
     * @return true if the field with the given name and given value meets the requirements specified in this
     * method.
     */
    public Boolean isValid(String name, short value) {
        return true;
    }

    /**
     * Validates a field of a given class by its NAME and VALUE of type {@code int}.
     *
     * @param name  field name.
     * @param value field value of type {@code int}.
     * @return true if the field with the given name and given value meets the requirements specified in this
     * method.
     */
    public Boolean isValid(String name, int value) {
        return true;
    }

    /**
     * Validates a field of a given class by its NAME and VALUE of type {@code long}.
     *
     * @param name  field name.
     * @param value field value of type {@code long}.
     * @return true if the field with the given name and given value meets the requirements specified in this
     * method.
     */
    public Boolean isValid(String name, long value) {
        return true;
    }

    /**
     * Validates a field of a given class by its NAME and VALUE of type {@code float}.
     *
     * @param name  field name.
     * @param value field value of type {@code float}.
     * @return true if the field with the given name and given value meets the requirements specified in this
     * method.
     */
    public Boolean isValid(String name, float value) {
        return true;
    }

    /**
     * Validates a field of a given class by its NAME and VALUE of type {@code double}.
     *
     * @param name  field name.
     * @param value field value of type {@code double}.
     * @return true if the field with the given name and given value meets the requirements specified in this
     * method.
     */
    public Boolean isValid(String name, double value) {
        return true;
    }

    /**
     * Validates a field of a given class by its NAME and VALUE of type {@code String}.
     *
     * @param name  field name.
     * @param value field value of type {@code String}.
     * @return true if the field with the given name and given value meets the requirements specified in this
     * method.
     */
    public Boolean isValid(String name, String value) {
        if (name == "name" && !value.contains("Kiryl")) return false;
        if (name == "surname" && !value.contains("Vinakurau")) return false;
        return true;
    }

    /**
     * Validates a field of a given class by its NAME and VALUE of type {@code Object}.
     *
     * @param name  field name.
     * @param value field value of type {@code Object}.
     * @return true if the field with the given name and given value meets the requirements specified in this
     * method.
     */
    public Boolean isValid(String name, Object value) {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(address,
                user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                '}';
    }
}
