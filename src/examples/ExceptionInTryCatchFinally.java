package examples;

import java.rmi.NotBoundException;

public class ExceptionInTryCatchFinally {
    public static class ExceptionTry {
        public static void whatReturn() throws Exception {
            try {
                System.out.println("try");
                throw new NullPointerException();
            } catch (NullPointerException e) {
                System.out.println("catch");
                throw new ClassNotFoundException();
            } finally {
                System.out.println("finally");
                throw new NotBoundException();
            }
        }
    }
    public static void main(String[] args) {
        try {
            ExceptionTry.whatReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
