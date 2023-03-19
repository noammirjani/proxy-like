package Commands;
import FileManager.FileManage;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class BlockCommand implements Command{
    private static final String ERROR_MSG = "invalid URL";
    private String url;

    public BlockCommand(String url){
        this.url = url;
        System.out.println(url);
        validate();
    }

    private boolean validate() {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e)  {
            System.out.println("NO!");
            throw new RuntimeException(ERROR_MSG);
        }
    }

    @Override
    public void execute() throws Exception{


        if(!FileManage.getInstance().searchInFile(fileName, url)) {
            FileManage.getInstance().writeToFile(fileName, url);
        }
    }
}
