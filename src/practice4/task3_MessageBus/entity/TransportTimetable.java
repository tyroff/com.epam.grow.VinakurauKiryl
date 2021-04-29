package practice4.task3_MessageBus.entity;

import java.util.Date;
import java.util.Objects;

/**
 * This class contains information about the bus: bus number, date and time of departure.
 *
 * @author Kiryl_Vinakurau
 */
public class TransportTimetable {

    private int transportNumber;
    private Date departureTime;

    /**
     * This constructor generates a random bus number from 1 to {@code maxBusNumber}. And a random departure time for
     * the bus is generated from the present time to one day.
     *
     * @param maxBusNumber maximum bus number.
     */
    public TransportTimetable(int maxBusNumber) {
        transportNumber = (int) (Math.random() * maxBusNumber + 1);
        departureTime = new Date(System.currentTimeMillis() + (int) (Math.random() * 86_400_000));
    }

    public int getTransportNumber() {
        return transportNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportTimetable that = (TransportTimetable) o;
        return transportNumber == that.transportNumber && Objects.equals(departureTime, that.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transportNumber, departureTime);
    }

    @Override
    public String toString() {
        return "bus #" + transportNumber +" | departure time: " + departureTime;
    }
}
