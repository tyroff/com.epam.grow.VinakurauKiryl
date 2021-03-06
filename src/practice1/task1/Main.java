package practice1.task1;


import practice1.task1.address.Address;
import practice1.task1.address.Country;
import practice1.task1.organization.Organization;
import practice1.task1.transport.FuelType;
import practice1.task1.transport.Transport;
import practice1.task1.transport.WheeledTransport;
import practice1.task1.utils.StorageInventoryNumbersUtil;

public class Main {

    static Address address = new Address();
    static Organization organization = new Organization();
    static WheeledTransport wheeledTransport = new WheeledTransport();
    static StorageInventoryNumbersUtil storageInventoryNumbersUtil = new StorageInventoryNumbersUtil();

    public static void main(String[] args) {
        Address legalAddress = new Address(Country.BELARUS, "Vitebsk", "Komsomol'skaya", 17, 11);
        Address physicalAddress = new Address(Country.BELARUS, "Vitebsk", "Tereshkovoj", 7);
        Organization autoPark = new Organization("Bus Deport #1", legalAddress, physicalAddress, 13);

        Transport transport1 = new WheeledTransport("MAZ", "206", FuelType.DIESEL_FUEL, 72, 90, 4, "Republic of " +
                "Belarus", 1000000, 15.3);
        Transport transport2 = new WheeledTransport("MAZ", "216", FuelType.DIESEL_FUEL, 88, 80, 4, "Republic of " +
                "Belarus", 999000, 14.8);
        Transport transport3 = new WheeledTransport("MAZ", "226", FuelType.ELECTRICITY, 69, 110, 4, "Republic of " +
                "Belarus", 1000002, 22.1);
        Transport transport4 = new WheeledTransport("MAZ", "236", FuelType.DIESEL_FUEL, 96, 86, 4, "Republic of " +
                "Belarus", 1100000, 9.4);
        Transport transport5 = new WheeledTransport("MAZ", "246", FuelType.GASOLINE, 101, 78, 4, "Republic of " +
                "Belarus", 1000900, 5.3);
        Transport transport6 = new WheeledTransport("MAZ", "256", FuelType.ELECTRICITY, 55, 120, 6, "Republic of " +
                "Belarus", 800070, 7.7);
        Transport transport7 = new WheeledTransport("MAZ", "266", FuelType.COMPRESSED_NATURAL_GAS, 150, 90, 8,
                "Republic of Belarus", 700070, 18.9);

        autoPark.getStorageInventoryNumbers().add(transport1);
        autoPark.getStorageInventoryNumbers().add(transport2);
        autoPark.getStorageInventoryNumbers().add(transport3);
        autoPark.getStorageInventoryNumbers().add(transport4);
        autoPark.getStorageInventoryNumbers().add(transport5);
        autoPark.getStorageInventoryNumbers().add(transport6);
        autoPark.getStorageInventoryNumbers().add(transport7);

        System.out.println(autoPark.toString());

        System.out.println("Cost autoPark: " + StorageInventoryNumbersUtil.coastAutoPark(autoPark.getStorageInventoryNumbers().readAll()) + " $");
        StorageInventoryNumbersUtil.wheeledTransportFuelConsumptionComparator(autoPark.getStorageInventoryNumbers().readAll());
        StorageInventoryNumbersUtil.sortByRangeWheeledTransport(autoPark.getStorageInventoryNumbers().readAll());
    }
}
