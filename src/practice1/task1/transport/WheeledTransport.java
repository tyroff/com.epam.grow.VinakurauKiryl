package practice1.task1.transport;

import java.util.Objects;

/**
 * The class extends from {@link practice1.task1.transport.Transport}. Describes a vehicle that has wheels and moves on a
 * solid surface.
 *
 * @author Kiryl_Vinakurau
 */
public class WheeledTransport extends Transport {

    private int numberOfWheels;
    private double fuelConsumption;

    public WheeledTransport() {
        super();
        numberOfWheels = 1;
        fuelConsumption = 0.1;
    }

    public WheeledTransport(String mark, String model, FuelType fuelType, int maxCapacityOfPeople, int maxSpeed,
                            int numberOfWheels, String countryOfManufacture, int price, double fuelConsumption) {
        super(mark, model, fuelType, maxCapacityOfPeople, maxSpeed, countryOfManufacture, price);
        this.numberOfWheels = numberOfWheels;
        this.fuelConsumption = fuelConsumption;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WheeledTransport)) return false;
        if (!super.equals(o)) return false;
        WheeledTransport that = (WheeledTransport) o;
        return numberOfWheels == that.numberOfWheels && Double.compare(that.fuelConsumption, fuelConsumption) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfWheels, fuelConsumption);
    }

    @Override
    public String toString() {
        return super.toString() +
            "\n     numberOfWheels = " + numberOfWheels + " pcs" +
            "\n     fuelConsumption = " + fuelConsumption + " l/100km" + "\n\n";
    }
}
