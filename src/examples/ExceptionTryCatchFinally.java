package examples;

public class ExceptionTryCatchFinally {
    private static class TryReturn {
        public static int whatReturn() {
            try {
                System.out.println("try");
                return 1;
            } catch (Exception e) {
                System.out.println("catch");
                return 2;
            } finally {
                System.out.println("finally");
                return 3; //return в блоке finally всегда подавляет все returns и exceptions в блоках try и catch!!!
            }
            /*
            try {
                System.out.println("try");
                throw new Exception();
            } catch(Exception e) {
                System.out.println("catch");
                return "return";
            } finally {
                System.out.println("finally");
                return "return in finally";
            }
             */
        }
    }

    public static void main(String[] args) {
        System.out.println(TryReturn.whatReturn());
    }
}
