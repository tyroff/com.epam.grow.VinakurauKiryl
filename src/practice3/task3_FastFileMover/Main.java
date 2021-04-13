package practice3.task3_FastFileMover;

import java.io.File;

public class Main {
    public static void main(String[] args) {
/*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write the path of the file to read (for example enter 'd:\\temp\\text.txt'");
        String pathRead = scanner.nextLine();
        File pathReadFile = new File(pathRead);
*/
        File pathReadFile = new File("d:\\move.txt");
/*
        System.out.print("Write the path of the directory to write (for example enter 'd:\\'");
        String pathWrite = scanner.nextLine();
        File pathWriteFile = new File(pathWrite);
*/
        File pathWriteFile = new File("d:\\temp\\move.txt");
//        scanner.close();
//        FastFileMover.movingDirectory(pathReadFile, pathWriteFile);
        FastFileMover.movingDirectoryUsingBuffer(pathReadFile, pathWriteFile);
    }
}
