package Commands;

import FileManager.FileManage;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class BlockCommand implements Command{

    public BlockCommand(){}

    @Override
    public void execute(String url) throws Exception{

        String result = FileManage.getInstance().searchInFile(fileName, url);
        if(Validations.checkUrl(url) && !result.equals("blocked - full")) { //change it to not found if solange says
            FileManage.getInstance().writeToFile(fileName, url);
        }
    }
}
