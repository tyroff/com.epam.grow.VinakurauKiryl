package practice1.task1.organization;

import practice1.task1.InventoryEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * An object of this class is found in every objects of class {@link practice1.task1.organization.Organization}.
 * It contains {@code Map <Integer, Object >} which stores all class objects
 * inherited from abstract class {@link practice1.task1.InventoryEntity} under the key {@code inventoryNumber}
 *
 * <p>
 * @author Kiryl_Vinakurau
 * </p>
 */
public final class StorageInventoryNumbers {

    private int inventoryNumber = 0;
    private Map<Integer, Object> storageInventoryNumbers;

    public StorageInventoryNumbers() {
        storageInventoryNumbers = new HashMap<>();
    }

    /**
     * Adds an object of type {@code <T extends InventoryEntity>} to the {@code Map<Integer, Object> storageInventoryNumbers}
     * with key {@code inventoryNumber}.
     * The key value is incremented by 1 after each addition of an object
     * of type {@code <T extends InventoryEntity>}
     * @param entity it is object of type {@code <T extends InventoryEntity>}.
     */
    public <T extends InventoryEntity> void add(T entity) {
        storageInventoryNumbers.put(++inventoryNumber, entity);
    }

    /**
     * Deletes an object of type {@code <T extends InventoryEntity>} to the {@code Map<Integer, Object> storageInventoryNumbers}
     * by key {@code inventoryNumber}.
     * @param inventoryNumber key of an {@code Integer} value.
     */
    public void deleteByInventoryNumber(Integer inventoryNumber) {
        storageInventoryNumbers.remove(inventoryNumber);
    }

    /**
     * Updates an object of type {@code <T extends InventoryEntity>} to the {@code Map<Integer, Object> storageInventoryNumbers}
     * by key {@code inventoryNumber}. The value key does not change.
     * @param inventoryNumber key of an {@code Integer} value.
     * @param entity it is object of type {@code <T extends InventoryEntity>}.
     */
    public <T extends InventoryEntity> void updateByInventoryNumber(Integer inventoryNumber, T entity) {
        storageInventoryNumbers.put(inventoryNumber, entity);
    }

    /**
     * Finds an object of type {@code <T extends InventoryEntity>} to the {@code Map<Integer, Object> storageInventoryNumbers}
     * by key {@code inventoryNumber}.
     * @param inventoryNumber key of an {@code Integer} value.
     * @return object of type {@code <T extends InventoryEntity>}.
     */
    public <T extends InventoryEntity> T readByInventoryNumber(Integer inventoryNumber) {
        return (T) storageInventoryNumbers.get(inventoryNumber);
    }

    /**
     * Finds all objects of type {@code <T extends InventoryEntity>} to the {@code Map<Integer, Object> storageInventoryNumbers}.
     * @return a map with all keys and values.
     */
    public Map<Integer, Object> readAll() {
        return storageInventoryNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageInventoryNumbers that = (StorageInventoryNumbers) o;
        return Objects.equals(storageInventoryNumbers, that.storageInventoryNumbers);
    }


    @Override
    public int hashCode() {
        return Objects.hash(storageInventoryNumbers);
    }
}
