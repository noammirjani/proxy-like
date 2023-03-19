package Commands;

public class DownloadCommand implements Command{
    private static final String ERROR_MSG = "invalid option";

    public DownloadCommand(){}

    private boolean validate(String options, String url) {
        try {
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }

    @Override
    public void execute(String data) throws Exception{
        //String Options, url = data.split(" ", 2);
        //validate()
    }
}
