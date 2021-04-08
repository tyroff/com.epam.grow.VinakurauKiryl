package com.epam.validation;

public class Address {
    String city;
    String street;
    String house;

    public Boolean isValid(String name, byte value) {
        return true;
    }

    public Boolean isValid(String name, short value) {
        return true;
    }

    public Boolean isValid(String name, int value) {
        return true;
    }

    public Boolean isValid(String name, long value) {
        return true;
    }

    public Boolean isValid(String name, float value) {
        return true;
    }

    public Boolean isValid(String name, double value) {
        return true;
    }

    public Boolean isValid(String name, String value) {
        if (name == "city" && !value.contains("Vit")) return false;
        if (name == "street" && !value.contains("Str")) return false;
        if (name == "house" && !value.contains("N")) return false;
        return true;
    }

    public Boolean isValid(String name, Object value) {
        return true;
    }
}
