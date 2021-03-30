package practice1.task1.organization;

import practice1.task1.address.Address;
import practice1.task1.annotation.ProdCode;
import practice1.task1.annotation.ThisCodeSmells;

import java.util.Objects;

/**
 * All objects of the {@code final class Organization} contain
 * the name, legal address, physical address, the number of employees
 * and {@link practice1.task1.organization.StorageInventoryNumbers}.
 * <p>
 * @author Kiryl_Vinakurau
 * </p>
 */
public final class Organization {

    private String name;
    private Address legalAddress;
    private Address physicalAddress;
    private int numberEmployees;
    private StorageInventoryNumbers storageInventoryNumbers;

    public Organization(String name, Address legalAddress, Address physicalAddress, int numberEmployees) {
        this.name = name;
        this.legalAddress = legalAddress;
        this.physicalAddress = physicalAddress;
        this.numberEmployees = numberEmployees;
        if(storageInventoryNumbers == null) {
            storageInventoryNumbers = new StorageInventoryNumbers();
        }
    }

    @ProdCode
    public String getName() {
        return name;
    }

    @ProdCode
    public Address getLegalAddress() {
        return legalAddress;
    }

    @ProdCode
    public Address getPhysicalAddress() {
        return physicalAddress;
    }

    @ProdCode
    public int getNumberEmployees() {
        return numberEmployees;
    }

    @ProdCode
    public StorageInventoryNumbers getStorageInventoryNumbers() {
        return storageInventoryNumbers;
    }

    @ProdCode
    public void setStorageInventoryNumbers(StorageInventoryNumbers storageInventoryNumbers) {
        this.storageInventoryNumbers = storageInventoryNumbers;
    }

    @ProdCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return numberEmployees == that.numberEmployees && Objects.equals(name, that.name) && Objects.equals(legalAddress, that.legalAddress) && Objects.equals(physicalAddress, that.physicalAddress);
    }

    @ProdCode
    @Override
    public int hashCode() {
        return Objects.hash(name, legalAddress, physicalAddress, numberEmployees);
    }

    @ProdCode
    @Override
    public String toString() {
        return name + ": " +
                "\n     legalAddress: " + legalAddress.toString() +
                "\n\n     physicalAddress: " + physicalAddress.toString() +
                "\n\n     numberEmployees: " + numberEmployees +
                "\n\n     storageInventoryNumbers:" + storageInventoryNumbers.toString();
    }
}
