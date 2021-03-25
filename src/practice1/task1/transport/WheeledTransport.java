package practice1.task1.transport;

public class WheeledTransport extends Transport {

    private int numberOfWheels;
    private double fuelConsumption;

    public WheeledTransport(String mark, String model, FuelType fuelType, int maxCapacityOfPeople, int maxSpeed, int numberOfWheels, String countryOfManufacture, int price, double fuelConsumption) {
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
    public String toString() {
        return super.toString() +
                "\n     numberOfWheels = " + numberOfWheels +
                "\n     fuelConsumption = " + fuelConsumption + "\n\n";
    }
}
