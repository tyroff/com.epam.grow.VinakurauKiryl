package practice2.task4;

import practice1.task1.address.Address;
import practice2.task4.utils.ClassFinder;
import practice2.task4.utils.ThisCodeSmellsHandler;

import java.util.List;

public class Main {

    private static ThisCodeSmellsHandler thisCodeSmellsHandler = new ThisCodeSmellsHandler();
    private static Address address = new Address();

    public static void main(String[] args) {
        List<Class<?>> classes = ClassFinder.find("practice1.task1");
        classes.forEach(nameClass -> {
            thisCodeSmellsHandler.handle(nameClass.getName());
        });
    }
}
