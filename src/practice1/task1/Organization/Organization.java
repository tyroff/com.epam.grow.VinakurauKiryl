package practice1.task1.Organization;

import practice1.task1.Address.Address;

import java.util.Map;

public class Organization {
    private String name;
    private Address legalAddress;
    private Address physicalAddress;
    private int numberEmployees;


    public Organization(String name, Address legalAddress, Address physicalAddress, int numberEmployees) {
        this.name = name;
        this.legalAddress = legalAddress;
        this.physicalAddress = physicalAddress;
        this.numberEmployees = numberEmployees;
    }

    public String getName() {
        return name;
    }

    public Address getLegalAddress() {
        return legalAddress;
    }

    public Address getPhysicalAddress() {
        return physicalAddress;
    }

    public int getNumberEmployees() {
        return numberEmployees;
    }

    @Override
    public String toString() {
        return name + ": " +
                "\n     legalAddress: " + legalAddress.toString() +
                "\n     physicalAddress: " + physicalAddress.toString() +
                "\n     numberEmployees: " + numberEmployees;
    }
}
