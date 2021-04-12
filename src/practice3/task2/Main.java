package practice3.task2;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a path: ");
        String path = scanner.nextLine();
        DiskAnalyzer.findFileMaxS(new File(path));
        scanner.close();
    }
}
