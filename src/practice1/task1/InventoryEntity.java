package practice1.task1;

import practice1.task1.annotation.ProdCode;
import practice1.task1.annotation.UseStackOnly;

import java.io.Serializable;

/**
 *The abstract {@code InventoryEntity} class is used to create a hierarchy of inventory objects
 * stored in the {@link practice1.task1.organization.StorageInventoryNumbers} class.
 * It implements {@code Serializable}.
 * <p>
 * @author Kiryl_Vinakurau
 * </p>
 */
public abstract class InventoryEntity implements Serializable {
    private int price;

    @ProdCode
    public int getPrice() {
        return price;
    }

    @ProdCode
    public void setPrice(int price) {
        this.price = price;
    }
}
