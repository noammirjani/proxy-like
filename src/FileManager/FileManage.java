package FileManager;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The FileManager class provides methods for managing files, such as reading and writing to files, searching
 * for specific data within files, and removing specific rows from files.
 */
public class FileManage {

    private static FileManage instance;

    final String NOT_BLOCKED = "not found";
    final String MATCH_URL = "blocked - full";
    final String PREFIX_URL = "blocked - prefix";

    /**
     * Gets the singleton instance of the FileManager class.
     * @return the FileManager instance
     */
    public static FileManage getInstance() {
        if (instance == null) {
            instance = new FileManage();
        }
        return instance;
    }

    /**
     * Removes a specific row from a file.
     * @param fileName the name of the file to remove the row from
     * @param url the data to remove from the file
     * @throws IOException if an error occurs while reading or writing to the file
     */
    public void removeRow(String fileName, String url) throws IOException {
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);
        if (lines.remove(url)){
            Files.write(path, lines);
        }
    }

    /**
     * Writes data to a file.
     * @param fileName the name of the file to write to
     * @param url the data to write to the file
     * @throws Exception if an error occurs while writing to the file
     */
    public void writeToFile(String fileName, String url) throws Exception {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(url + "\n");
        } catch (IOException e) {
            throwException("cannot write", fileName);
        }
    }

    /**
     * Reads data from a file.
     * @param fileName the name of the file to read from
     * @return a list of strings containing the data read from the file
     * @throws Exception if an error occurs while reading from the file
     */
    public List<String> getFileData(String fileName) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throwException("cannot read", fileName);
        }
        return null;
    }

    /**
     * Searches for specific data within a file.
     * @param fileName the name of the file to search within
     * @param wantedUrl the data to search for within the file
     * @return a string indicating whether the data was found in the file, or if it was not found
     * @throws Exception if an error occurs while reading from the file
     */
    public String searchInFile(String fileName, String wantedUrl) throws Exception {
        if (!Files.exists(Paths.get("blocked.txt"))) return NOT_BLOCKED;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(wantedUrl)) return MATCH_URL;
                if (wantedUrl.startsWith(line + "/")) return PREFIX_URL;
            }
        } catch (IOException e) {
            throwException("cannot read", fileName);
        }
        return NOT_BLOCKED;
    }

    /**
     * Throws an exception with a specified message and file name.
     * @param str the message to include in the exception
     * @param fileName the name of the file related to the exception
     * @throws Exception with the specified message and file name
     */
    public void throwException(String str, String fileName) throws Exception{
        throw new Exception(str + " " + fileName);
    }
}