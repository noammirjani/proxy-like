package Commands;

public class DownloadCommand implements Command{
    private static final String ERROR_MSG = "invalid option";
    private String Options;
    private String url;


    public DownloadCommand(String[] data){
        this.Options = data[0];
        this.url = data[1];
        validate();
    }

    private boolean validate() {
        try {
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }

    @Override
    public void execute() throws Exception{}
}
