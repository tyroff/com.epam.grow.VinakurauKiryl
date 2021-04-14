package practice1.task1.address;

import java.io.Serializable;
import practice2.task3.annotation.ProdCode;
import practice2.task3.annotation.ThisCodeSmell;

import java.util.Objects;

/**
 * All objects of the {@code final class Address} contain the country name,
 * city name, street name, house number and building number.
 *
 * @author Kiryl_Vinakurau
 */

@ThisCodeSmell(reviewer = "Vinakurau Kiryl")
@ThisCodeSmell(reviewer = "Uladzislau Shalamitski")
public final class Address implements Serializable{
    private Country country;
    private String town;
    private String street;
    private transient int houseNumber;
    private transient int indexNumber;

    public Address() {
        country = Country.BELARUS;
        town = "town";
        street = "street";
        houseNumber = 0;
        indexNumber = 0;
    }

    public Address(Country country, String town, String street, int houseNumber, int indexNumber) {
        this.country = country;
        this.town = town;
        this.street = street;
        this.houseNumber = houseNumber;
        this.indexNumber = indexNumber;
    }

    public Address(Country country, String town, String street, int houseNumber) {
        this.country = country;
        this.town = town;
        this.street = street;
        this.houseNumber = houseNumber;
        this.indexNumber = 0;
    }

    public Country getCountry() {
        return country;
    }

    @ThisCodeSmell(reviewer = "Kiryl Vinakurau")
    @ThisCodeSmell(reviewer = "Uladzislau Shalamitski")
    public String getTown() {
        return town;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    @ThisCodeSmell(reviewer = "Kiryl Vinakurau")
    public int getIndexNumber() {
        return indexNumber;
    }

    /**
     * Displays a message on the console that this method has been started.
     */
    @ProdCode
    public void prodCodeContains() {
        System.out.println("Method prodCodeContains is started");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber && indexNumber == address.indexNumber && country == address.country
                && Objects.equals(town, address.town) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, town, street, houseNumber, indexNumber);
    }

    @Override
    public String toString() {
        return "\n     country = " + country +
                "\n     town = '" + town + '\'' +
                "\n     street = '" + street + '\'' +
                "\n     houseNumber = " + houseNumber +
                "\n     indexNumber = " + indexNumber;
    }
}
