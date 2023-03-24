package Commands;

import FileManager.FileManage;

/**
 * A class that represents the "Block" command.
 * Implements the Command interface.
 */
public class BlockCommand implements Command {

    /**
     * Constructs a new BlockCommand object.
     */
    public BlockCommand() {}

    /**
     * Executes the "Block" command.
     * Searches for the given URL in the blocked file,
     * and if it's not already blocked, adds it to the file.
     *
     * @param url The URL to be blocked.
     * @throws Exception If there's an error searching for or writing to the blocked file.
     */
    @Override
    public void execute(String url) throws Exception {

        // Search for the given URL in the blocked file.
        String result = FileManage.getInstance().searchInFile(fileName, url);

        // If the URL is valid and not already blocked, add it to the file.
        if(Validations.checkUrl(url) && !result.equals("blocked - full")) {
            FileManage.getInstance().writeToFile(fileName, url);
        }
    }
}