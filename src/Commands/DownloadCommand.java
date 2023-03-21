package Commands;
import DecoratorForDownload.*;
import DecoratorForDownload.Decorator;

import java.net.HttpURLConnection;
import java.io.*;

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
        String url = dataArray[1];
        String outputFile = dataArray[2];

        // function to check download flags(note: flags are valid)
        preDownload(options, url, outputFile);


        //create an object of cc = ConcreteAccessUrl
        //build decorator
        //decorator.oprion(cc.getConnection, url)
        //download - solange function

    }

    private void preDownload(String[] options, String url, String outputFile) throws Exception {
        // Create an instance of the ConcreteAccessUrl class
        ConcreteAccessUrl concreteAccessUrl = new ConcreteAccessUrl(url);

        // Build the decorator object based on the flags in the options string
        AccessUrl decorator = concreteAccessUrl;
        for (String flag : options) {
            switch (flag) {
                case "b":
                    decorator = new BlockedUrlAccess(decorator);
                    break;
                case "c":
                    decorator = new CookiesAccess(decorator);
                    break;
                case "h":
                    decorator = new HtmlAccess(decorator);
                    break;
                case "i":
                    decorator = new ImageAccess(decorator);
                    break;
                default:
                    // throw new IllegalArgumentException("Unknown option flag: " + flag);
                    break;
            }
        }

        // Download the file using the decorator object
        decorator.operation(concreteAccessUrl.getUrlConnection(), url);

        System.out.println("Decorator is great");

        HttpURLConnection httpURLConnection = (HttpURLConnection)concreteAccessUrl.getUrlConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();

        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new Exception(Integer.toString(responseCode));
        }
        downloadContent(outputFile, httpURLConnection);
    }

    private void downloadContent(String outputFile, HttpURLConnection httpURLConnection) throws Exception{

        String inputLine = "";

        // we check if the response is 200 and if the content-type is TEXT
        BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

        PrintWriter output = new PrintWriter(new FileOutputStream(outputFile));

        // read each line
        while ((inputLine = in.readLine()) != null) {
            output.print(inputLine);
        }

        // we finished writing, fail on closing input is not fatal
        try { in.close(); } catch (Exception e) {}
        output.close();

    }

}
