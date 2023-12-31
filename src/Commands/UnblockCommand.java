package Commands;

import FileManager.FileManage;

/**
 * Command to unblock a URL in the blocked.txt file.
 */
public class UnblockCommand implements Command{

    /**
     * The name of the file containing the blocked URLs.
     */
    private static final String fileName = "blocked.txt";

    /**
     * Creates a new instance of the UnblockCommand class.
     */
    public UnblockCommand(){}

    /**
     * Removes the specified URL from the list of blocked URLs in the blocked.txt file.
     *
     * @param url the URL to be unblocked.
     * @throws Exception if an error occurs while removing the URL from the file.
     */
    @Override
    public void execute(String[] url) throws Exception {

        Validations.numOfParameters(url, 1);

        FileManage.getInstance().removeRow(fileName, url[0]);
    }
}