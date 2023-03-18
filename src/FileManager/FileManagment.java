package FileManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileManagment {
    public static void writeToFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println("Successfully wrote to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }
    }

    public static String readFromFile(String fileName) {
        String content = "";
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                content += line + "\n";
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading file.");
            e.printStackTrace();
        }
        return content;
    }
}