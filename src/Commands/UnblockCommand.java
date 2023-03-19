package Commands;
import FileManager.FileManage;
import java.net.URL;


public class UnblockCommand implements Command{
    private static final String ERROR_MSG = "invalid URL";
    private String url;

    public UnblockCommand(String url){
        this.url = url;
        validate();
    }

    private boolean validate() {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(ERROR_MSG);
        }
    }

    @Override
    public void execute() throws Exception {

        FileManage.getInstance().removeRow(fileName, url);
    }
}
