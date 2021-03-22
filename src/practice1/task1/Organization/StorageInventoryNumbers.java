package practice1.task1.Organization;

import practice1.task1.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StorageInventoryNumbers extends Entity{
    private int inventoryNumber = 0;

    private Map<Integer, Object> storageInventoryNumbers;

    public StorageInventoryNumbers() {
        storageInventoryNumbers = new HashMap<>();
    }

    public Map<Integer, Object> getStorageInventoryNumbers() {
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
