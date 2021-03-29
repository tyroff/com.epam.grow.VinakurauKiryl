package practice2.task2.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MetaDataOfClassUtil {
    public void getClassFields(Class<?> cls)
    {
        Field[] fields = cls.getDeclaredFields();
        System.out.println("    Fields:");
        for (Field field : fields) {
            Class<?> fld = field.getType();
            System.out.println("        Field name : " + field.getName());
            System.out.println("        Field type : " + fld.getName());
            System.out.println();
        }
    }

    public void getClassMethods(Class<?> cls)
    {
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