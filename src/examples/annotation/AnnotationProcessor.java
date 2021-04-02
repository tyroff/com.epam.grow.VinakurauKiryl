package examples.annotation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AnnotationProcessor {

    private static Map<String, Object> servicesMap = new HashMap<>();

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(String.class);

        loadService("examples.annotation.SimpleService");
        loadService("examples.annotation.LazyService");
        loadService("java.lang.String");

        servicesMap.forEach((k, v) -> System.out.println("Key = " + k + " | Value = " + v));
    }

    static void inspectService(Class<?> service) {
        if (service.isAnnotationPresent(Service.class)) {
            Service ser = service.getAnnotation(Service.class);
            System.out.println(service.getName() + " = " + ser.name() + " = " + ser.lazyLoad());

            Method[] massService = service.getMethods();
            for (int i = 0; massService.length > i; i++) {
                if (massService[i].isAnnotationPresent(Init.class)) {
                    System.out.println("method " + massService[i].getName() + ": is @Init");
                } else {
                    System.out.println("method " + massService[i].getName() + ": is NOT @Init");
                }
            }
            System.out.println("\n");
        } else {
            System.out.println(service.getName() + " = 0\n");
        }
    }

    static void loadService(String className) throws IllegalAccessException, InstantiationException {
        try {
            Class<?> clazz = Class.forName(className);
            if (clazz.isAnnotationPresent(Service.class)) {
                Object serviceObj = clazz.newInstance();
                servicesMap.put(className, serviceObj);
            } else {
                throw new ClassNotFoundException(clazz.getName());
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
