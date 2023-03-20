package FileManager;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileManage {
    private static FileManage instance;

    final String NOT_BLOCKED = "not found";
    final String MATCH_URL = "blocked - full";
    final String PREFIX_URL = "blocked - prefix";


    public static FileManage getInstance() {
        if (instance == null) {
            instance = new FileManage();
        }
        return instance;
    }

    public void removeRow(String fileName, String url) throws IOException {
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);
        if (lines.remove(url)){
            Files.write(path, lines);
        }
    }

    public void writeToFile(String fileName, String url) throws Exception {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(url + "\n");
        } catch (IOException e) {
            throwException("cannot write", fileName);
        }
    }

    public List<String> getFileData(String fileName) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            return lines;
        } catch (IOException e) {
            throwException("cannot read", fileName);
        }
        return null;
    }

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

    public void throwException(String str, String fileName) throws Exception{

        throw new Exception(str + " " + fileName);
    }
}