package practice1.task1.Transport;

abstract class LandTransport extends Transport {

    public LandTransport(String mark, String model, FuelType fuelType, int maxCapacityOfPeople, int maxSpeed, String countryOfManufacture, int price) {
        super(mark, model, fuelType, maxCapacityOfPeople, maxSpeed, countryOfManufacture, price);
    }
}
