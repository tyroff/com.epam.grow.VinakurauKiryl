package practice2.task2;

import practice2.task2.organization.StorageInventoryNumbers;

import java.io.Serializable;

/**
 *The abstract {@code InventoryEntity} class is used to create a hierarchy of inventory objects
 * stored in the {@link StorageInventoryNumbers} class.
 * It implements {@code Serializable}.
 * <p>
 * @author Kiryl_Vinakurau
 * </p>
 */
public abstract class InventoryEntity implements Serializable {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
