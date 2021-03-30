package practice1.task1.address;

import practice1.task1.annotation.ProdCode;

import java.util.Objects;

/**
 * All objects of the {@code final class Address} contain the country name,
 * city name, street name, house number and building number.
 *
 * <p>
 * @author Kiryl_Vinakurau
 * </p>
 */

public final class Address {
    private Country country;
    private String town;
    private String street;
    private int houseNumber;
    private int indexNumber;

    public Address(Country country, String town, String street, int houseNumber, int indexNumber) {
        this.country = country;
        this.town = town;
        this.street = street;
        this.houseNumber = houseNumber;
        this.indexNumber = indexNumber;
    }

    @ProdCode
    public Country getCountry() {
        return country;
    }

    @ProdCode
    public String getTown() {
        return town;
    }

    @ProdCode
    public String getStreet() {
        return street;
    }

    @ProdCode
    public int getHouseNumber() {
        return houseNumber;
    }

    @ProdCode
    public int getIndexNumber() {
        return indexNumber;
    }

    @ProdCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber && indexNumber == address.indexNumber && country == address.country && Objects.equals(town, address.town) && Objects.equals(street, address.street);
    }

    @ProdCode
    @Override
    public int hashCode() {
        return Objects.hash(country, town, street, houseNumber, indexNumber);
    }

    @ProdCode
    @Override
    public String toString() {
        return  "\n     country = " + country +
                "\n     town = '" + town + '\'' +
                "\n     street = '" + street + '\'' +
                "\n     houseNumber = " + houseNumber +
                "\n     indexNumber = " + indexNumber;
    }
}
