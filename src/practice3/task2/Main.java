package practice3.task2;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a path (for example enter 'd:\\': ");
        String path = scanner.nextLine();
        File file = new File(path);
        DiskAnalyzer.findFileMaxS(file);
        DiskAnalyzer.findFiveFilesMaxSize(file);
        DiskAnalyzer.FindAverageFileSize(file);
        DiskAnalyzer.findFilesFoldersByFirstLetter(file);
        scanner.close();
    }
}
