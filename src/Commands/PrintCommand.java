package Commands;

import FileManager.FileManage;
import java.util.Collections;
import java.util.List;

/**
 * The PrintCommand class represents the command for printing the list of blocked URLs.
 */
public class PrintCommand implements Command {

    /**
     * The name of the file that stores the blocked URLs.
     */
    public static final String fileName = "blocked.txt";

    /**
     * Constructs a new instance of the PrintCommand.
     */
    public PrintCommand(){}

    /**
     * Executes the PrintCommand to print the list of blocked URLs.
     *
     * @param data the command data (not used in this command).
     * @throws Exception if an error occurs while executing the command.
     */
    @Override
    public void execute(String data) throws Exception {

        Validations.noneParameterCommand(data);
        List<String> lines = FileManage.getInstance().getFileData(fileName);
        Collections.sort(lines);
        System.out.println(String.join("\n", lines));
    }
}
