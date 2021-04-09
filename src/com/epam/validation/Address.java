package com.epam.validation;

/**
 * The {@code Address class} stores all the data about the location.
 *
 * @author Kiryl_Vinakurau
 */
public class Address {
    String city;
    String street;
    String house;
    Coordinates coordinates;

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
        if (name == "city" && !value.contains("Vit")) return false;
        if (name == "street" && !value.contains("Str")) return false;
        if (name == "house" && !value.contains("N")) return false;
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
}
