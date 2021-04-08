package com.epam.validation;

public class User {
    private String name;
    private String surname;
    private Address address;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

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
        if (name == "name" && !value.contains("Kiryl")) return false;
        if (name == "surname" && !value.contains("Vinakurau")) return false;
        return true;
    }

    public Boolean isValid(String name, Object value) {
        return true;
    }
}
