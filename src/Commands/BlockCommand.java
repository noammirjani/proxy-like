package Commands;
import FileManager.FileManage;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class BlockCommand implements Command{
    private static final String ERROR_MSG = "invalid URL";

    public BlockCommand(){}

    private boolean validate(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e)  {
            throw new RuntimeException(ERROR_MSG);
        }
    }

    @Override
    public void execute(String url) throws Exception{

        if(validate(url) && !FileManage.getInstance().searchInFile(fileName, url)) {
            FileManage.getInstance().writeToFile(fileName, url);
        }
    }
}
