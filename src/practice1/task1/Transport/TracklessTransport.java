package practice1.task1.Transport;

abstract class TracklessTransport extends LandTransport{

    public TracklessTransport(String mark, String model, FuelType fuelType, int maxCapacityOfPeople, int maxSpeed, String countryOfManufacture, int price) {
        super(mark, model, fuelType, maxCapacityOfPeople, maxSpeed, countryOfManufacture, price);
    }
}
