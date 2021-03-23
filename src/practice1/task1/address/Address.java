package practice1.task1.address;

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

    public Country getCountry() {
        return country;
    }

    public String getTown() {
        return town;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber && indexNumber == address.indexNumber && country == address.country && Objects.equals(town, address.town) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, town, street, houseNumber, indexNumber);
    }

    @Override
    public String toString() {
        return  "\n     country = " + country +
                "\n     town = '" + town + '\'' +
                "\n     street = '" + street + '\'' +
                "\n     houseNumber = " + houseNumber +
                "\n     indexNumber = " + indexNumber;
    }
}
