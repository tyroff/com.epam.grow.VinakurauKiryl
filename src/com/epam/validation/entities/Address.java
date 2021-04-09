package com.epam.validation.entities;

import java.util.Objects;

/**
 * The {@code Address class} stores all the data about the location.
 *
 * @author Kiryl_Vinakurau
 */
public class Address {
    private String city;
    private String street;
    private String house;
    private Coordinates coordinates;
    private LocationDescription locationDescription;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocationDescription getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(LocationDescription locationDescription) {
        this.locationDescription = locationDescription;
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
        if (name == "coordinates" && value == null) return false;
        if (name == "locationDescription" && value == null) return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(house,
                address.house) && Objects.equals(coordinates, address.coordinates) && Objects.equals(locationDescription, address.locationDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, house, coordinates, locationDescription);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", coordinates=" + coordinates +
                ", locationDescription=" + locationDescription +
                '}';
    }
}
