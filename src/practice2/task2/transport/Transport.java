package practice2.task2.transport;

import practice2.task2.InventoryEntity;

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

    public Transport() {
        mark = "markNull";
        model = "modelNull";
        fuelType = FuelType.OTHER;
        maxCapacityOfPeople = 1;
        maxSpeed = 100;
        countryOfManufacture = "countryNull";
    }

    public Transport(String mark, String model, FuelType fuelType, int maxCapacityOfPeople, int maxSpeed, String countryOfManufacture, int price) {
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
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return maxCapacityOfPeople == transport.maxCapacityOfPeople && maxSpeed == transport.maxSpeed &&  Objects.equals(mark, transport.mark) && Objects.equals(model, transport.model) && fuelType == transport.fuelType && Objects.equals(countryOfManufacture, transport.countryOfManufacture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, model, fuelType, maxCapacityOfPeople, maxSpeed, countryOfManufacture);
    }

    @Override
    public String toString() {
        return  "\n" + mark + " " + model +
                "\n     fuelType = " + fuelType +
                "\n     maxCapacityOfPeople = " + maxCapacityOfPeople + " pcs" +
                "\n     maxSpeed = " + maxSpeed + " km/h" +
                "\n     countryOfManufacture = " + countryOfManufacture +
                "\n     price = " + super.getPrice() + " $";
    }
}
