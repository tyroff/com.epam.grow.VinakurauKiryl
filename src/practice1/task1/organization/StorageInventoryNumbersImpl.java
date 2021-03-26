package practice1.task1.organization;

import practice1.task1.InventoryEntity;
import practice1.task1.transport.WheeledTransport;
import practice1.task1.transport.WheeledTransportFuelConsumptionComparator;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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

    /**
     * Finds objects {@link practice1.task1.transport.WheeledTransport} corresponding to the specified range
     * of parameters {@code CapacityOfPeople} and {@code Speed}.
     * When objects that meet the entered parameters are found, it outputs them to the console.
     */
    public static void sortByRangeWheeledTransport(Map<Integer, ? extends InventoryEntity> mapInventoryEntity) {
        int minCapacityOfPeople;
        int maxCapacityOfPeople;
        int minSpeed;
        int maxSpeed;
        try(Scanner in = new Scanner(System.in)) {
            System.out.print("\nCapacity of people:\n   Enter a natural number.\nMin = ");
            minCapacityOfPeople = in.nextInt();
            if(minCapacityOfPeople < 0) {
                throw new IllegalArgumentException();
            }
            System.out.print("\nEnter a natural number > Min.\nMax = ");
            maxCapacityOfPeople = in.nextInt();
            if(maxCapacityOfPeople <= minCapacityOfPeople) {
                throw new IllegalArgumentException();
            }

            System.out.print("\nSpeed:\n   Enter a natural number.\nMin = ");
            minSpeed = in.nextInt();
            if(minSpeed < 0) {
                throw new IllegalArgumentException();
            }
            System.out.print("\nEnter a natural number > Min.\nMax = ");
            maxSpeed = in.nextInt();
            if(maxSpeed <= minSpeed) {
                throw new IllegalArgumentException();
            }

            Map<Integer, WheeledTransport> wheeledTransportMap;
            if(!mapInventoryEntity.isEmpty()) {
                wheeledTransportMap = new HashMap<>();
                mapInventoryEntity.forEach((k, v) -> {
                    if(v instanceof WheeledTransport) {
                        wheeledTransportMap.put(k, (WheeledTransport) v);
                    }
                });
                AtomicInteger count = new AtomicInteger();
                wheeledTransportMap.forEach((k, v) -> {
                    if(v.getMaxCapacityOfPeople() >= minCapacityOfPeople && v.getMaxCapacityOfPeople() <= maxCapacityOfPeople){
                        if(v.getMaxSpeed() >= minSpeed && v.getMaxSpeed() <= maxSpeed) {
                            System.out.println(v);
                            count.getAndIncrement();
                        }
                    }
                });
                if(count.get() == 0) {
                    System.out.println("\nNot found!");
                }
            } else {
                System.out.println("These objects are missing.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong data!");
        }
    }
}
