package practice2.task2;

import practice1.task1.address.Address;
import practice1.task1.address.Country;
import practice1.task1.organization.Organization;
import practice1.task1.organization.StorageInventoryNumbers;
import practice1.task1.transport.FuelType;
import practice1.task1.transport.Transport;
import practice1.task1.transport.WheeledTransport;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static Address address = new Address();
    static Organization organization = new Organization();
    static WheeledTransport wheeledTransport = new WheeledTransport();
    static StorageInventoryNumbers storageInventoryNumbersUtil = new StorageInventoryNumbers();

    public static void main(String[] args) {

        try {
            Class<Address> addressClass = Address.class;
            Constructor<Address> addressConstructor = addressClass.getConstructor(Country.class, String.class,
                    String.class, int.class, int.class);
            Constructor<Address> addressConstructor1 = addressClass.getConstructor(Country.class, String.class,
                    String.class, int.class);
            Address legalAddress = addressConstructor.newInstance(Country.BELARUS, "Vitebsk", "Komsomol'skaya", 17, 11);
            Address physicalAddress = addressConstructor1.newInstance(Country.BELARUS, "Vitebsk", "Tereshkovoj", 7);

            Class<Organization> organizationClass = Organization.class;
            Constructor<Organization> organizationConstructor = organizationClass.getConstructor(String.class,
                    Address.class, Address.class, int.class);
            Organization autoPark = organizationConstructor.newInstance("Bus Deport #1", legalAddress,
                    physicalAddress, 13);

            Class<WheeledTransport> transportClass = WheeledTransport.class;
            Constructor<WheeledTransport> wheeledTransportConstructor = transportClass.getConstructor(String.class,
                    String.class, FuelType.class, int.class, int.class, int.class, String.class, int.class,
                    double.class);
            Transport transport1 = wheeledTransportConstructor.newInstance("MAZ", "206", FuelType.DIESEL_FUEL, 72, 90
                    , 4, "Republic of Belarus", 1000000, 15.3);
            Transport transport2 = wheeledTransportConstructor.newInstance("MAZ", "216", FuelType.DIESEL_FUEL, 88, 80
                    , 4, "Republic of Belarus", 999000, 14.8);
            Transport transport3 = wheeledTransportConstructor.newInstance("MAZ", "226", FuelType.ELECTRICITY, 69,
                    110, 4, "Republic of Belarus", 1000002, 22.1);
            Transport transport4 = wheeledTransportConstructor.newInstance("MAZ", "236", FuelType.DIESEL_FUEL, 96, 86
                    , 4, "Republic of Belarus", 1100000, 9.4);
            Transport transport5 = wheeledTransportConstructor.newInstance("MAZ", "246", FuelType.GASOLINE, 101, 78,
                    4, "Republic of Belarus", 1000900, 5.3);
            Transport transport6 = wheeledTransportConstructor.newInstance("MAZ", "256", FuelType.ELECTRICITY, 55,
                    120, 6, "Republic of Belarus", 800070, 7.7);

            WheeledTransport transport7 = new WheeledTransport();
            Class<? extends Transport> wheeledTransportClass = transport7.getClass();
            Field wheeledTransportNumberOfWheels = wheeledTransportClass.getDeclaredField("numberOfWheels");
            Field wheeledTransportFuelConsumption = wheeledTransportClass.getDeclaredField("fuelConsumption");
            wheeledTransportNumberOfWheels.setAccessible(true);
            wheeledTransportFuelConsumption.setAccessible(true);
            wheeledTransportNumberOfWheels.setInt(transport7, 8);
            wheeledTransportFuelConsumption.setDouble(transport7, 23.34);
            Method getTransportNumberOfWheels = wheeledTransportClass.getMethod("getNumberOfWheels");
            Object resultValueNumberOfWheels = getTransportNumberOfWheels.invoke(transport7);
            System.out.println("ResultValueNumberOfWheels = " + resultValueNumberOfWheels);

            autoPark.getStorageInventoryNumbers().add(transport1);
            autoPark.getStorageInventoryNumbers().add(transport2);
            autoPark.getStorageInventoryNumbers().add(transport3);
            autoPark.getStorageInventoryNumbers().add(transport4);
            autoPark.getStorageInventoryNumbers().add(transport5);
            autoPark.getStorageInventoryNumbers().add(transport6);
            autoPark.getStorageInventoryNumbers().add(transport7);

            System.out.println(autoPark.toString());

            System.out.println();
            List<Object> list = new ArrayList<>();
            list.add(address);
            list.add(organization);
            list.add(wheeledTransport);
            list.add(storageInventoryNumbersUtil);
            practice1.task1.utils.MetaDataOfClassUtil metaDataOfClassUtil =
                    new practice1.task1.utils.MetaDataOfClassUtil();
            list.forEach(obj -> {
                System.out.println("Class name = " + obj.getClass().getSimpleName());
                metaDataOfClassUtil.getClassFields(obj.getClass());
                metaDataOfClassUtil.getClassMethods(obj.getClass());
                System.out.println("\n");
            });

        } catch (NoSuchMethodException e) {
            System.out.println("Not found Method: " + e.toString());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("Illegal access to: " + e.toString());
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("Invocation target: " + e.toString());
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("Instantiation: " + e.toString());
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            System.out.println("No such field: " + e.toString());
            e.printStackTrace();
        }
    }
}
