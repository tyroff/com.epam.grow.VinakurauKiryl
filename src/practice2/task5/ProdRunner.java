package practice2.task5;

import practice2.task3.annotation.ProdCode;
import practice2.task4.utils.ClassFinder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Annotation processor {@link practice2.task3.annotation.ProdCode} in the project {@code Practice 1 Task 1}.
 *
 * @author Kiryl_Vinakurau
 */
public class ProdRunner {
    /**
     * Finds all project classes {@code Practice 1 Task 1}. In each class, it searches for methods marked with the
     * {@link practice2.task3.annotation.ProdCode} annotation and runs them.
     */
    public static void main(String[] args) {
        List<Class<?>> classes = ClassFinder.find("practice1.task1");
        classes.forEach(pathClass -> {
            try {
                Class<?> clazz = Class.forName(pathClass.getName());
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(ProdCode.class)) {
                        try {
                            Object obj = clazz.getConstructor().newInstance();
                            method.invoke(obj);
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            System.out.println("No public default constructor found in class " + clazz.getSimpleName());
                            e.printStackTrace();
                        }
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
