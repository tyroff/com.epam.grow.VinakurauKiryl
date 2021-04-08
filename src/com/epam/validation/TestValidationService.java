package com.epam.validation;

public class TestValidationService {
    public static void main(String[] args) {
        Address address1 = new Address();
        address1.city = "Belarus";
        address1.street = "Street";
        address1.house = "N1";

        Address address2 = new Address();
        address2.city = null;
        address2.street = "Avenue";
        address2.house = "00";

        User user1 = new User();
        user1.setName("Name");
        user1.setSurname("Surname");
        user1.setAddress(address1);

        User user2 = new User();
        user2.setName("Kiryl");
        user2.setSurname("Vinakurau");
        user2.setAddress(address2);

        ValidationService validationService = new ValidationService();
        System.out.println("address1 = " + validationService.validate(address1));
        System.out.println("address2 = " + validationService.validate(address2));
        System.out.println("user1 = " + validationService.validate(user1));
        System.out.println("user2 = " + validationService.validate(user2));
    }
}
