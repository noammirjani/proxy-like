package Commands;
import DecoratorForDownload.*;
import java.io.*;
import java.net.URL;

public class DownloadCommand implements Command{
    private static final int NUM_OF_PARAMETERS = 3;
    public DownloadCommand(){}

    @Override
    public void execute(String data) throws Exception{
        String[] dataArray = data.split(" ", 3);

        Validations.numOfParameters(dataArray.length, NUM_OF_PARAMETERS);
        Validations.checkUrl(dataArray[1]);
        Validations.checkOptions(dataArray[0]);

        String[] options = dataArray[0].split("");
        URL url = new URL(dataArray[1]);
        String outputFile = dataArray[2];

        preDownload(options, url);
        downloadContent(url, outputFile);
    }

    private void preDownload(String[] options, URL url) throws Exception {

        AccessUrl decorator = new ConcreteAccessUrl(url);
        for (String flag : options) {
            switch (flag) {
                case "b" -> decorator = new BlockedUrlAccess(decorator);
                case "c" -> decorator = new CookiesAccess(decorator);
                case "h" -> decorator = new HtmlAccess(decorator);
                case "i" -> decorator = new ImageAccess(decorator);
                default -> {  // throw new IllegalArgumentException("Unknown option flag: " + flag);
                }
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
                OutputStream output = new BufferedOutputStream(new FileOutputStream(outputFile));
        ) {
            int b;
            while ((b = input.read()) != -1) {
                output.write(b);
            }
        }
    }
}
