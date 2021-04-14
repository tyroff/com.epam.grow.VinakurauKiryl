package practice3.task1_Serialization;

import practice1.task1.address.Address;
import practice1.task1.address.Country;
import practice1.task1.transport.FuelType;
import practice1.task1.transport.Transport;
import practice1.task1.transport.WheeledTransport;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Address.dat"))) {
            Address address = new Address(Country.BELARUS, "Vitebsk", "Komsomol'skaya", 17, 11);
            objectOutputStream.writeObject(address);
            System.out.println("Object Address is was write.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException | SecurityException | IOException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Transport.dat"))) {
            Transport transport = new WheeledTransport("MAZ", "206", FuelType.DIESEL_FUEL, 72, 90, 4, "Republic of " +
                    "Belarus", 1000000, 15.3);
            objectOutputStream.writeObject(transport);
            System.out.println("Object Transport is was write.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException | SecurityException | IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Address.dat"))) {
            Address addressRead = (Address) objectInputStream.readObject();
            System.out.println(addressRead.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException | SecurityException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Transport.dat"))) {
            WheeledTransport wheeledTransportRead = (WheeledTransport) objectInputStream.readObject();
            System.out.println(wheeledTransportRead.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException | SecurityException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
