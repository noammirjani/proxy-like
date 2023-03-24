package Commands;
import DecoratorForDownload.*;
import java.io.*;
import java.net.URL;

public class DownloadCommand implements Command{
    String[] options = {};
    URL url = null;
    String outputFile = "";


    public DownloadCommand(){}


    private void setData(String data) throws Exception{
        String[] dataArray = data.split(" ");

        if(Validations.numOfParametersFlex(dataArray.length, 3, 2)){
            //2 parameters
            options = new String[]{};
            url = new URL(dataArray[0]);
            outputFile = dataArray[1];
        }
        else{
            //3 parameters
            options = dataArray[0].split("");
            url = new URL(dataArray[1]);
            outputFile = dataArray[2];
        }
        Validations.checkOptions(options);
        Validations.checkUrl(url.toString());
    }


    @Override
    public void execute(String data) throws Exception{

        setData(data);
        preDownload();
        downloadContent(url, outputFile);
    }


    private void preDownload() throws Exception {

        AccessUrl decorator = new ConcreteAccessUrl(url);
        for (String flag : options) {
            switch (flag) {
                case "b" -> decorator = new BlockedUrlAccess(decorator);
                case "c" -> decorator = new CookiesAccess(decorator);
                case "h" -> decorator = new HtmlAccess(decorator);
                case "i" -> decorator = new ImageAccess(decorator);
                default -> {}
            }
        }
    }


    /**
     * Downloads a remote file to the local disk.
     *
     * @param outputFile the output file to save the source to.
     * @param url        the source URL.
     * @exception IOException upon opening streams or reading. Closing of stream IOException is caught.
     */
    private void downloadContent(URL url, String outputFile) throws IOException {
        try (
                InputStream input = new BufferedInputStream(url.openStream());
                OutputStream output = new BufferedOutputStream(new FileOutputStream(outputFile))
        ) {
            int b;
            while ((b = input.read()) != -1) {
                output.write(b);
            }
        }
        catch (IOException e) {
            throw new IOException("cannot write output file");
        }
    }
}
