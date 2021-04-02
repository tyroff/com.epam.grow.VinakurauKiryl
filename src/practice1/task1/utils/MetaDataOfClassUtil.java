package practice1.task1.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * A utility class that contains methods for providing information about the class of interest, such as: the name of
 * the fields, the type of the fields, the name of the methods, the type of the methods, the type of the input
 * parameters.
 */
public class MetaDataOfClassUtil {

    /**
     * Prints the field name and field type of the resulting class to the console.
     *
     * @param cls class.
     */
    public void getClassFields(Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        System.out.println("    Fields:");
        for (Field field : fields) {
            Class<?> fld = field.getType();
            System.out.println("        Field name : " + field.getName());
            System.out.println("        Field type : " + fld.getName());
            System.out.println();
        }
    }

    /**
     * Prints to the console the name of the method, the type of the method, and the type or types of the method
     * input parameters of the resulting class.
     *
     * @param cls class.
     */
    public void getClassMethods(Class<?> cls) {
        Method[] methods = cls.getDeclaredMethods();
        System.out.println("    Methods:");
        for (Method method : methods) {
            System.out.println("        Method name : " + method.getName());
            System.out.println("        Return type : " + method.getReturnType().getName());
            Class<?>[] params = method.getParameterTypes();
            System.out.print("        Method parameters: ");
            for (Class<?> param : params) System.out.print(" " + param.getName() + "; ");
            System.out.println("\n");
        }
    }
}