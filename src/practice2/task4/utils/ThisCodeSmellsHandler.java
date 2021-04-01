package practice2.task4.utils;

import practice2.task3.annotation.ThisCodeSmells;

import java.sql.SQLOutput;

public class ThisCodeSmellsHandler {

    public void handle(String classPath) {
        try {
            Class<?> clazz = Class.forName(classPath);
            if(clazz.isAnnotationPresent(ThisCodeSmells.class)) {
                System.out.println("YES -> " + clazz.getSimpleName());
            } else {
                System.out.println("NO  -> " + clazz.getSimpleName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*
if (ac.getClass().isAnnotationPresent(DoItLikeThis.class)) {
        // process the annotation, "ac" being the instance of the object we are inspecting

        }

        Field[] fields = ac.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(DoItLikeThat.class)) {
                    DoItLikeThat fAnno = field.getAnnotation(DoItLikeThat.class);
                    System.out.println("Field: " + field.getName());
                    System.out.println("DoItLikeThat:" + fAnno.shouldDoItLikeThat());
                    for (String role : fAnno.roles()) {
                        System.out.println("Role: " + role);
                    }
                }
            }
public class TestAnnotationAnalyzer {
    public void analyz(Class<?> clazz) throws Exception {
        Method[] methods = clazz.getMethods();
        int pass = 0;
        int fail = 0;

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                // Получаем доступ к атрибутам
                Test test = method.getAnnotation(Test.class);
                Class expected = test.expected();
                try {
                    method.invoke(null);
                    pass++;
                } catch (Exception e) {
                    if (Exception.class != expected) {
                        fail++;
                    } else {
                        pass++;
                    }
                }
            }
        }
    }
}
*/
}
