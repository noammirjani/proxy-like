package Commands;
import FileManager.FileManage;
import java.net.URL;

public class UnblockCommand implements Command{

    public UnblockCommand(){}

    @Override
    public void execute(String url) throws Exception {

        FileManage.getInstance().removeRow(fileName, url);
    }
}
