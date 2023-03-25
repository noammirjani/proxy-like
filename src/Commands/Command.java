package Commands;

public interface Command {

    // This constant is the name of the file used to store the blocked URLs
    String fileName = "blocked.txt";

    /**
     * This method executes the command with the given data.
     *
     * @param data the data needed to execute the command
     * @throws Exception if there is an error executing the command
     */
    void execute(String[] data) throws Exception;
}