package Commands;

import java.util.Arrays;

public class DownloadCommand implements Command{
    private static final int NUM_OF_PARAMETERS = 3;

    public DownloadCommand(){}

    @Override
    public void execute(String data) throws Exception{
        String[] dataArray = data.split(" ", 3);
        try {
            Validations.numOfParameters(dataArray.length, NUM_OF_PARAMETERS);
            Validations.checkUrl(dataArray[1]);
            Validations.checkOptions(dataArray[0]);
            //  call to ==> FileManage.getInstance().searchInFile(fileName, url) ==> find if blocked

        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        String options = dataArray[0];
        String url = dataArray[1];
        String outputFile = dataArray[2];
        System.out.println("In DownloadCommand " + options + " " + url + " " + outputFile);

    }
}
