package Commands;
import FileManager.FileManage;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class BlockCommand implements Command{
    private static final String ERROR_MSG = "invalid URL";

    public BlockCommand(){}


    @Override
    public void execute(String url) throws Exception{

        String result = FileManage.getInstance().searchInFile(fileName, url);
        if(Validations.checkUrl(url) && "not found".equals(result)) {
            FileManage.getInstance().writeToFile(fileName, url);
        }
    }
}
