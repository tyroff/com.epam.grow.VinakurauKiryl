package practice3.task3_FastFileMover;

import java.io.*;

public final class FastFileMover {

    /**
     * Moves a file from one directory to another directory. The entrance takes both paths. Using simple FileStreams
     *
     * @param readPath  the path of the file to be moved.
     * @param writePath the path where you want to move the file.
     */
    public static void movingDirectory(File readPath, File writePath) {
        try (FileInputStream fin = new FileInputStream(readPath); FileOutputStream fos =
                new FileOutputStream(writePath)) {
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
            fos.write(buffer, 0, buffer.length);
        } catch (FileNotFoundException e) {
            System.out.println("File " + e + " not found.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        readPath.delete();
    }

    /**
     * moves a file from one directory to another directory. The entrance takes both paths. Using simple FileStreams
     * and a 100Kb buffer.
     *
     * @param readPath  the path of the file to be moved.
     * @param writePath the path where you want to move the file.
     */
    public static void movingDirectoryUsingBuffer(File readPath, File writePath) {
        try (FileInputStream fin = new FileInputStream(readPath); FileOutputStream fos =
                new FileOutputStream(writePath)) {
            byte[] buffer = new byte[100];
            int noOfBytes = 0;
            while ((noOfBytes = fin.read(buffer)) != -1) {
                fos.write(buffer, 0, noOfBytes);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + e + " not found.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        readPath.delete();
    }
}
