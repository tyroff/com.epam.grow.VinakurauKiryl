package practice1.task1.organization;

import practice1.task1.InventoryEntity;
import practice1.task1.transport.WheeledTransport;
import practice1.task1.transport.WheeledTransportFuelConsumptionComparator;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Implements other specific methods of class {@link practice1.task1.organization.StorageInventoryNumbers}
 *
 * @author Kiryl_Vinakurau
 */
public final class StorageInventoryNumbersImpl {

    private static Integer totalCost;

    /**
     * Calculates the total cost of objects of type {@code <? extends InventoryEntity>}
     * @return total cost of objects of type X
     */
    public static Integer coastAutoPark(Map<Integer, ? extends InventoryEntity> mapInventoryEntity){
        totalCost = 0;
        mapInventoryEntity.forEach((k, v) -> totalCost += v.getPrice()) ;
        return totalCost;
    }

    /**
     * Sorts the {@link practice1.task1.transport.WheeledTransport} object by the {@code fuelConsumption} parameter
     * and prints the value to the console.
     */
    public static void wheeledTransportFuelConsumptionComparator(Map<Integer, ? extends InventoryEntity> mapInventoryEntity) {
        Comparator<WheeledTransport> comparator = new WheeledTransportFuelConsumptionComparator();
        TreeSet<WheeledTransport> transportTreeSet = new TreeSet(comparator);
        mapInventoryEntity.forEach((k, v) -> transportTreeSet.add((WheeledTransport) v));
        System.out.println("\n==============================================\nSorted by fuelConsumption: ");
        transportTreeSet.forEach(wheeledTransport -> System.out.print(wheeledTransport));
    }
}
