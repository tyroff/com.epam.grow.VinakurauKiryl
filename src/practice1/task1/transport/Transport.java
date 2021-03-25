package practice1.task1.transport;

import practice1.task1.InventoryEntity;

import java.util.Objects;

/**
 * The abstract class {@code Transport} is the root of the vehicle class hierarchy.
 * <p>
 * @author Kiryl Vinakurau
 * </p>
 */

public abstract class Transport extends InventoryEntity {
    private String mark;
    private String model;
    private FuelType fuelType;
    private int maxCapacityOfPeople;
    private int maxSpeed;
    private String countryOfManufacture;
    private int price;

    public Transport(String mark, String model, FuelType fuelType, int maxCapacityOfPeople, int maxSpeed, String countryOfManufacture, int price) {
        this.mark = mark;
        this.model = model;
        this.fuelType = fuelType;
        this.maxCapacityOfPeople = maxCapacityOfPeople;
        this.maxSpeed = maxSpeed;
        this.countryOfManufacture = countryOfManufacture;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return maxCapacityOfPeople == transport.maxCapacityOfPeople && maxSpeed == transport.maxSpeed && price == transport.price && Objects.equals(mark, transport.mark) && Objects.equals(model, transport.model) && fuelType == transport.fuelType && Objects.equals(countryOfManufacture, transport.countryOfManufacture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, model, fuelType, maxCapacityOfPeople, maxSpeed, countryOfManufacture, price);
    }

    @Override
    public String toString() {
        return  "\n" + mark + " " + model +
                "\n     fuelType = " + fuelType +
                "\n     maxCapacityOfPeople = " + maxCapacityOfPeople +
                "\n     maxSpeed = " + maxSpeed +
                "\n     countryOfManufacture = " + countryOfManufacture +
                "\n     price = " + price;
    }
}
