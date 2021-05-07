package examples;

public class NOK {
    public static void main(String[] args) {
        int nok = 48;
        int sum = 0;
        for (int i = 1; i < nok + 1; i++) {
            if (nok % i == 0) {
                System.out.print(i + " ");
                sum += i;
            }
        }
        System.out.println("\nsumNOK = " + sum);
    }
}
