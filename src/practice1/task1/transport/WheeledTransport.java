package practice1.task1.transport;

import practice1.task1.annotation.ProdCode;
import practice1.task1.annotation.UseStackOnly;

import java.util.Objects;

/**
 *The class extends {@link practice1.task1.transport.Transport}
 * and objects of this class describe wheeled vehicles moving on the ground.
 */
public class WheeledTransport extends Transport {
    private int numberOfWheels;
    private double fuelConsumption;

    public WheeledTransport(String mark, String model, FuelType fuelType, int maxCapacityOfPeople, int maxSpeed,
                            int numberOfWheels, String countryOfManufacture, int price, double fuelConsumption) {
        super(mark, model, fuelType, maxCapacityOfPeople, maxSpeed, countryOfManufacture, price);
        this.numberOfWheels = numberOfWheels;
        this.fuelConsumption = fuelConsumption;
    }

    @ProdCode
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @ProdCode
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @ProdCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WheeledTransport)) return false;
        if (!super.equals(o)) return false;
        WheeledTransport that = (WheeledTransport) o;
        return numberOfWheels == that.numberOfWheels && Double.compare(that.fuelConsumption, fuelConsumption) == 0;
    }

    @ProdCode
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfWheels, fuelConsumption);
    }

    @ProdCode
    @Override
    public String toString() {
        return super.toString() +
                "\n     numberOfWheels = " + numberOfWheels + " pcs" +
                "\n     fuelConsumption = " + fuelConsumption + " l/100km" + "\n\n";
    }
}
