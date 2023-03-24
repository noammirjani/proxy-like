/**
 * The DownloadCommand class implements the Command interface and represents a command that
 * downloads a remote file from a given URL to the local disk.
 */
package Commands;
import DecoratorForDownload.*;
import java.io.*;
import java.net.URL;

public class DownloadCommand implements Command{
    /** The command options. */
    String[] options = {};

    /** The URL of the file to download. */
    URL url = null;

    /** The path to save the downloaded file. */
    String outputFile = "";

    /**
     * Initializes a new instance of the DownloadCommand class.
     */
    public DownloadCommand(){}


    /**
     * Sets the data for the download command.
     *
     * @throws Exception if there is an error setting the data.
     */
    private void setData(String[] dataArray) throws Exception{

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

    /**
     * Executes the download command.
     *
     * @param data the command data containing the URL and options (if any) for the download.
     * @throws Exception if there is an error executing the command.
     */
    @Override
    public void execute(String[] data) throws Exception{
        setData(data);
        preDownload();
        downloadContent(url, outputFile);
    }

    /**
     * Applies any specified decorators to the AccessUrl object before downloading the file.
     *
     * @throws Exception if there is an error applying the decorators.
     */
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
