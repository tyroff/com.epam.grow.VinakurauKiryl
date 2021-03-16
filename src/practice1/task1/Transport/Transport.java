package practice1.task1.Transport;

import java.util.Date;

public abstract class Transport {
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
    public String toString() {
        return  mark + " " + model +
                "\n     fuelType = " + fuelType +
                "\n     maxCapacityOfPeople = " + maxCapacityOfPeople +
                "\n     maxSpeed = " + maxSpeed +
                "\n     countryOfManufacture = " + countryOfManufacture +
                "\n     price = " + price;
    }
}
