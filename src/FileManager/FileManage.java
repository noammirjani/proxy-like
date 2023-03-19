package FileManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileManagment {

    public static void writeToFile(String fileName, String url) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(url + "\n");
            System.out.println("Successfully wrote to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }
    }

    public static String readFromFile(String fileName) {
        String content = "";
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                content += line + "\n";
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading file.");
            e.printStackTrace();
        }
        return content;
    }
}