package com.epam.validation;

import com.epam.validation.entities.Address;
import com.epam.validation.entities.Coordinates;
import com.epam.validation.entities.LocationDescription;
import com.epam.validation.entities.User;
import com.epam.validation.utils.ValidationService;

import java.io.File;

public class TestValidationService {
    public static void main(String[] args) {
        Coordinates coordinates1 = new Coordinates("55.170861", "30.215140");
        Coordinates coordinates2 = new Coordinates("30.215140", "55.170861");

        File image1 = new File("C:/Windows/Web/Screen/img100.jpg");
        File image2 = new File("C:/Windows/Web/Screen/img101.png");
        File image3 = new File("C:/Windows/Web/Screen/img102.jpg");

        LocationDescription locationDescription1 = new LocationDescription("Здание находится рядом с торговым домом " +
                "Омега. Близко от автобусной остановки \"Торговый дом Омега\".");
        File images[] = locationDescription1.getImages();
        images[0] = image1;
        images[1] = image2;
        images[2] = image3;
        locationDescription1.setImages(images);

        Address address1 = new Address();
        address1.setCity("Vitebsk");
        address1.setStreet("Stroiteley");
        address1.setHouse("N11a");
        address1.setCoordinates(coordinates1);
        address1.setLocationDescription(locationDescription1);

        Address address2 = new Address();
        address2.setCity(null);
        address2.setStreet("Avenue");
        address2.setHouse("00");
        address2.setCoordinates(coordinates2);
        address2.setLocationDescription(null);

        User user1 = new User();
        user1.setName("Name");
        user1.setSurname("Surname");
        user1.setAddress(address1);

        User user2 = new User();
        user2.setName("Kiryl");
        user2.setSurname("Vinakurau");
        user2.setAddress(address1);

        ValidationService validationService = new ValidationService();
        System.out.println("address1 = " + validationService.validate(address1));
        System.out.println("address2 = " + validationService.validate(address2));
        System.out.println("user1 = " + validationService.validate(user1));
        System.out.println("user2 = " + validationService.validate(user2));
    }
}
