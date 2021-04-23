package practice4.task3_MessageBus.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * This class contains information about the bus: bus number, date and time of departure.
 *
 * @author Kiryl_Vinakurau
 */
public class BusMessage {

    private int busNumber;
    private Date departureTime;

    /**
     * This constructor generates a random bus number from 1 to {@code maxBusNumber}. And a random departure time for
     * the bus is generated from the present time to one day.
     *
     * @param maxBusNumber maximum bus number.
     */
    public BusMessage(int maxBusNumber) {
        busNumber = (int) (Math.random() * maxBusNumber + 1);
        departureTime = new Date(System.currentTimeMillis() + (int) (Math.random() * 86_400_000));
    }

    public int getBusNumber() {
        return busNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusMessage that = (BusMessage) o;
        return busNumber == that.busNumber && Objects.equals(departureTime, that.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(busNumber, departureTime);
    }

    @Override
    public String toString() {
        return "bus #" + busNumber +" | departure time: " + departureTime;
    }
}
