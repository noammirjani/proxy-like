package Commands;
import FileManager.FileManage;


public class PrintCommand implements Command{

    public PrintCommand(){}

    @Override
    public void execute(String data) throws Exception {

        FileManage.getInstance().printSortedData(fileName);
    }
}
