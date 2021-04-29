package examples;

public class ExceptionExample extends Error {
    public static void main(String[] args) {
        try {

        } catch (/*IllegalAccessException | */Exception e) {
            System.out.println(e);
        }
    }
}

class Exception1 extends RuntimeException {
    void method1(){
        try {

        } catch (Error | RuntimeException/* | Throwable*/ e) {
            System.out.println(e);
        }
    }
}