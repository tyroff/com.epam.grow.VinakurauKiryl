package practice3.task2;

import java.io.File;
import java.util.*;

/**
 * A command line utility that accepts a path as input (for example, C: \)
 *
 * @author Kiryl_Vinakurau
 */
public final class DiskAnalyzer {
    private static int maxCountCharS = 0;
    private static File fileHasMaxS;
    private static final int MAX_COUNT_FILE_BIG_SIZE = 5;
    private static long countSizeFiles = 0;
    private static int countFilesInDirectory = 0;
    private static List<File> fileList = new ArrayList<>();
    private static List<File> directoryFileList = new ArrayList<>();
    private static Map<Long, File> fileTreeMap = new TreeMap<>();
    private static Map<Character, Integer> countFilesByFirstLetter = new TreeMap<>();
    private static Map<Character, Integer> countDirectoriesByFirstLetter = new TreeMap<>();
    private static Set<Character> keysLetter = new TreeSet<>();

    /**
     * Search for a file name with the maximum number of letters 's' in the name, display the path to it.
     *
     * @param rootFile directory path.
     */
    public static void findFileMaxS(File rootFile) {
        if (fileList.isEmpty()) fileList = findFiles(rootFile);
        fileList.forEach(file -> {
            int count = 0;
            char[] fileChar = file.getName().toLowerCase().toCharArray();
            for (int i = 0; i < fileChar.length; i++) {
                if (fileChar[i] == 's') ++count;
            }
            if (count > maxCountCharS) {
                maxCountCharS = count;
                fileHasMaxS = file;
            }
        });
        System.out.println("Path max count char 'S' -> " + fileHasMaxS.getPath() + "\n");
        maxCountCharS = 0;
    }

    /**
     * Finds the five largest files in the specified directory.
     *
     * @param rootFile directory path.
     */
    public static void findFiveFilesMaxSize(File rootFile) {
        if (fileList.isEmpty()) fileList = findFiles(rootFile);
        if (fileTreeMap.isEmpty()) fileTreeMap = createTreeMapFiles(rootFile);
        ArrayList<Long> listKeys = new ArrayList<>(fileTreeMap.keySet());
        int count = 0;
        for (int i = listKeys.size() - 1; i >= 0; i--) {
            System.out.println(fileTreeMap.get(listKeys.get(i)) + "." + listKeys.get(i));
            if (count >= MAX_COUNT_FILE_BIG_SIZE) break;
            count++;
        }
        System.out.println();
    }

    /**
     * Print to the console the average file size in the specified directory or any of its subdirectories
     *
     * @param rootFile directory path.
     */
    public static void FindAverageFileSize(File rootFile) {
        if (fileTreeMap.isEmpty()) fileTreeMap = createTreeMapFiles(rootFile);
        fileTreeMap.forEach((k, v) -> {
            countSizeFiles += k;
            countFilesInDirectory++;
        });

        System.out.println("Average file size directory \"" + rootFile + "\" = " + countSizeFiles / countFilesInDirectory + " byte\n");
        countSizeFiles = 0;
        countFilesInDirectory = 0;
    }

    /**
     * Prints to the console the number of files and folders, broken down by the first letters of the alphabet.
     *
     * @param rootFile directory path.
     */
    public static void findFilesFoldersByFirstLetter(File rootFile) {
        if (fileList.isEmpty()) fileList = findFiles(rootFile);

        fileList.forEach(file -> {
            char key = file.getName().toUpperCase().charAt(0);
            if (!countFilesByFirstLetter.containsKey(key)) {
                countFilesByFirstLetter.put(key, 1);
                keysLetter.add(key);
            } else {
                int value = countFilesByFirstLetter.get(key) + 1;
                countFilesByFirstLetter.put(key, value);
            }
        });

        directoryFileList.forEach(file -> {
            char key = file.getName().toUpperCase().charAt(0);
            if (!countDirectoriesByFirstLetter.containsKey(key)) {
                countDirectoriesByFirstLetter.put(key, 1);
                keysLetter.add(key);
            } else {
                int value = countDirectoriesByFirstLetter.get(key) + 1;
                countDirectoriesByFirstLetter.put(key, value);
            }
        });

        keysLetter.forEach(character -> {
            System.out.println("The letter " + character + " begins: " + countFilesByFirstLetter.get(character)
                    + " files and " + countDirectoriesByFirstLetter.get(character) + " folders.");
        });
        System.out.println();
    }

    /**
     * Finds all files in the specified directory.
     *
     * @param rootFile directory path.
     * @return {@code ArrayLis<File>}.
     */
    private static List<File> findFiles(File rootFile) {
        if (rootFile.isDirectory()) {
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (int i = 0; i < directoryFiles.length; i++) {
                    directoryFileList.add(directoryFiles[i]);
                }
            }
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        findFiles(file);
                    } else {
                        fileList.add(file);
                    }
                }
            }
        }
        return fileList;
    }

    /**
     * Files found in method {@code List<File> findFiles(File rootFile)} are added to {@code TreeMap<File>}.
     *
     * @param rootFile directory path.
     * @return {@code TreeMap<File>}.
     */
    private static Map<Long, File> createTreeMapFiles(File rootFile) {
        if (fileList.isEmpty()) fileList = findFiles(rootFile);
        fileList.forEach(file -> fileTreeMap.put((Long) file.length(), file));
        return fileTreeMap;
    }
}
