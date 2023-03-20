package Commands;

public interface Command {

    String fileName = "blocked.txt";
    void execute(String data) throws Exception;
}
