package practice1.task1.Address;

public class Address {
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
    public String toString() {
        return  "\n     country = " + country +
                "\n     town = '" + town + '\'' +
                "\n     street = '" + street + '\'' +
                "\n     houseNumber = " + houseNumber +
                "\n     indexNumber = " + indexNumber;
    }
}
