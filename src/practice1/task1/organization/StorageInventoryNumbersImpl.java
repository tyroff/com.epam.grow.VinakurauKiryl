package practice1.task1.organization;

import practice1.task1.InventoryEntity;

import java.util.Map;

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
}
