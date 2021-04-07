package practice2.task4.utils;

import practice2.task3.annotation.ThisCodeSmell;
import practice2.task3.annotation.ThisCodeSmells;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Processes classes, fields, and methods that contain one or more {@link practice2.task3.annotation.ThisCodeSmell}
 * annotations.
 */
public class ThisCodeSmellsHandler {

    /**
     * In the fields of the class, in the methods of the class and in the class, it looks for the
     * {@link practice2.task3.annotation.ThisCodeSmell} annotations and prints the information to the console.
     *
     * @param classPath a class in which the presence of the {@link practice2.task3.annotation.ThisCodeSmell}
     *                  annotation is checked everywhere
     */
    public void handle(String classPath) {
        try {
            Class<?> clazz = Class.forName(classPath);
            if (clazz.isAnnotationPresent(ThisCodeSmell.class)) {
                ThisCodeSmell thisCodeSmell = clazz.getAnnotation(ThisCodeSmell.class);
                System.out.println("Class " + clazz.getSimpleName() + " - reviewer: " + thisCodeSmell.reviewer());
            }
            if (clazz.isAnnotationPresent(ThisCodeSmells.class)) {
                ThisCodeSmell[] thisCodeSmells = clazz.getAnnotationsByType(ThisCodeSmell.class);
                for (ThisCodeSmell thisCodeSmell : thisCodeSmells) {
                    System.out.println("Class " + clazz.getSimpleName() + " - reviewer: " + thisCodeSmell.reviewer());
                }
            }
            Field[] publicFields = clazz.getFields();
            for (Field field : publicFields) {
                if (field.isAnnotationPresent(ThisCodeSmell.class)) {
                    ThisCodeSmell thisCodeSmell = field.getAnnotation(ThisCodeSmell.class);
                    System.out.println("Field of class " + clazz.getSimpleName() + ": " + field.getType() + " " +
                            field.getName() + " - reviewer: " + thisCodeSmell.reviewer());
                }
                if (field.isAnnotationPresent(ThisCodeSmells.class)) {
                    ThisCodeSmell[] thisCodeSmells = field.getAnnotationsByType(ThisCodeSmell.class);
                    for (ThisCodeSmell thisCodeSmell : thisCodeSmells) {
                        System.out.println("Field of class " + clazz.getSimpleName() + ": " + field.getType() + " " +
                                field.getName() + " - reviewer: " + thisCodeSmell.reviewer());
                    }
                }
            }
            Field[] privateFields = clazz.getDeclaredFields();
            for (Field field : privateFields) {
                if (field.isAnnotationPresent(ThisCodeSmell.class)) {
                    ThisCodeSmell thisCodeSmell = field.getAnnotation(ThisCodeSmell.class);
                    System.out.println("Field of class " + clazz.getSimpleName() + ": " + field.getType() + " " +
                            field.getName() + " - reviewer: " + thisCodeSmell.reviewer());
                }
                if (field.isAnnotationPresent(ThisCodeSmells.class)) {
                    ThisCodeSmell[] thisCodeSmells = field.getAnnotationsByType(ThisCodeSmell.class);
                    for (ThisCodeSmell thisCodeSmell : thisCodeSmells) {
                        System.out.println("Field of class " + clazz.getSimpleName() + ": " + field.getType() + " " +
                                field.getName() + " - reviewer: " + thisCodeSmell.reviewer());
                    }
                }
            }
            Method[] publicMethods = clazz.getMethods();
            for (Method method : publicMethods) {
                if (method.isAnnotationPresent(ThisCodeSmell.class)) {
                    ThisCodeSmell thisCodeSmell = method.getAnnotation(ThisCodeSmell.class);
                    System.out.println("Method of class " + clazz.getSimpleName() + ": " + method.getReturnType() +
                            " " + method.getName() + " - reviewer: " + thisCodeSmell.reviewer());
                }
                if (method.isAnnotationPresent(ThisCodeSmells.class)) {
                    ThisCodeSmell[] thisCodeSmells = method.getAnnotationsByType(ThisCodeSmell.class);
                    for (ThisCodeSmell thisCodeSmell : thisCodeSmells) {
                        System.out.println("Field of class " + clazz.getSimpleName() + ": " + method.getReturnType() + " " +
                                method.getName() + " - reviewer: " + thisCodeSmell.reviewer());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
