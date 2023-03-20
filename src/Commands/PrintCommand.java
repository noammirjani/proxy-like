package Commands;
import FileManager.FileManage;

import java.util.Collections;
import java.util.List;


public class PrintCommand implements Command{

    public PrintCommand(){}

    @Override
    public void execute(String data) throws Exception {

        Validations.noneParameterCommand(data);
        List<String> lines = FileManage.getInstance().getFileData(fileName);
        Collections.sort(lines);
        System.out.println(String.join("\n", lines));

    }
}
