package practice1.task1.transport;

import practice1.task1.InventoryEntity;

import java.io.Serializable;
import java.util.Objects;

/**
 * The abstract class {@code Transport} is the root of the vehicle class hierarchy.
 *
 * @author Kiryl Vinakurau
 */
public abstract class Transport extends InventoryEntity implements Serializable {
    private String mark;
    private String model;
    private FuelType fuelType;
    private transient int maxCapacityOfPeople;
    private transient int maxSpeed;
    private String countryOfManufacture;

    public Transport() {
        mark = "mark";
        model = "model";
        fuelType = FuelType.OTHER;
        maxCapacityOfPeople = 1;
        maxSpeed = 10;
        countryOfManufacture = "countryOfManufacture";
    }

    public Transport(String mark, String model, FuelType fuelType, int maxCapacityOfPeople, int maxSpeed,
                     String countryOfManufacture, int price) {
        this.mark = mark;
        this.model = model;
        this.fuelType = fuelType;
        this.maxCapacityOfPeople = maxCapacityOfPeople;
        this.maxSpeed = maxSpeed;
        this.countryOfManufacture = countryOfManufacture;
        super.setPrice(price);
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public int getMaxCapacityOfPeople() {
        return maxCapacityOfPeople;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getCountryOfManufacture() {
        return countryOfManufacture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transport)) return false;
        if (!super.equals(o)) return false;
        Transport transport = (Transport) o;
        return maxCapacityOfPeople == transport.maxCapacityOfPeople && maxSpeed == transport.maxSpeed && mark.equals(transport.mark) && model.equals(transport.model) && fuelType == transport.fuelType && countryOfManufacture.equals(transport.countryOfManufacture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mark, model, fuelType, maxCapacityOfPeople, maxSpeed, countryOfManufacture);
    }

    @Override
    public String toString() {
        return "\n" + mark + " " + model +
            "\n     fuelType = " + fuelType +
            "\n     maxCapacityOfPeople = " + maxCapacityOfPeople + " pcs" +
            "\n     maxSpeed = " + maxSpeed + " km/h" +
            "\n     countryOfManufacture = " + countryOfManufacture +
            "\n     price = " + super.getPrice() + " $";
    }
}
