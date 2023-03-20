package Commands;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Validations {
    private static final String INVALID_URL = "invalid URL";
    private static final String INVALID_COMMAND = "invalid command";
    public static boolean checkUrl(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e)  {
            throw new RuntimeException(INVALID_URL);
        }
    }

    public static void numOfParameters(int CommandLen, int numOfParams) {
        if (CommandLen < numOfParams) {
            throw new IllegalArgumentException(INVALID_COMMAND);
        }
    }

    // Implement it !
    public static void checkOptions(String options) {


    }



}
