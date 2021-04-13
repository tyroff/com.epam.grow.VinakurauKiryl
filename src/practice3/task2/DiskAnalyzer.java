package practice3.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiskAnalyzer {
    private static List<File> fileList = new ArrayList<>();
    private static int maxCountS = 0;
    private static File fileHasMaxS;
    private static final int MAX_COUNT_FILE_BIG_SIZE = 5;

    /**
     * Search for a file name with the maximum number of letters 's' in the name, display the path to it.
     * @param rootFile directory path
     */
    public static void findFileMaxS(File rootFile) {
        List<File> fileList = new ArrayList<>();
        fileList = findFiles(rootFile);
        fileList.forEach(file -> {
            int count = 0;
            char[] fileChar = file.getName().toLowerCase().toCharArray();
            for (int i = 0; i < fileChar.length; i++) {
                if (fileChar[i] == 's') ++count;
            }
            if (count > maxCountS) {
                maxCountS = count;
                fileHasMaxS = file;
            }
        });
        System.out.println("Path max count S -> " + fileHasMaxS.getPath() + "\n");
    }
    public static void findFiveFilesMaxSize(File rootFile) {
        List<File> fileList = findFiles(rootFile);
        Map<Long, File> fileMap = new TreeMap<>();
        fileList.forEach(file -> fileMap.put((Long) file.length(), file));
        ArrayList<Long> listKeys = new ArrayList<>(fileMap.keySet());
        int count = 0;
        for(int i = listKeys.size() - 1; i >= 0; i--){
            System.out.println(fileMap.get(listKeys.get(i)) + "." + listKeys.get(i));
            if (count >= MAX_COUNT_FILE_BIG_SIZE) break;
            count++;
        }
    }

    /**
     * Finds all files in the specified directory.
     * @param rootFile directory path.
     * @return {@code ArrayLis<File>}
     */
    public static List<File> findFiles(File rootFile) {
        if (rootFile.isDirectory()) {
            File[] directoryFiles = rootFile.listFiles();
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
}
