package Commands;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class Validations {

    private static final String INVALID_URL = "invalid URL";
    private static final String INVALID_COMMAND = "invalid command";
    private static final String INVALID_OPTION = "invalid option";
    private static final List<String> FLAGS = List.of("b","c","h","i");

    /**
     * Checks if a given URL is valid.
     *
     * @param url the URL to be checked
     * @return true if the URL is valid, false otherwise
     * @throws RuntimeException if the URL is invalid
     */
    public static boolean checkUrl(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e)  {
            throw new RuntimeException(INVALID_URL);
        }
    }

    /**
     * Checks if the number of parameters for a command is correct.
     *
     * @param commandLen the length of the command
     * @param numOfParams the number of parameters the command should have
     * @throws IllegalArgumentException if the number of parameters is incorrect
     */
    public static void numOfParameters(int commandLen, int numOfParams) {
        if (commandLen != numOfParams+1) {
            throw new IllegalArgumentException(INVALID_COMMAND);
        }
    }


    public static boolean numOfParametersFlex(int commandLen, int ...numOfParams) {

        for (int i : numOfParams) {
            if (commandLen+1 == i) {
                return true;
            }
        }

        throw new IllegalArgumentException(INVALID_COMMAND);
    }

    /**
     * Checks if the given options are valid.
     *
     * @param flags the options to be checked
     * @throws IllegalArgumentException if the options are invalid
     */
    public static void checkOptions(String[] flags) {

        if(flags.length == 0) {return;}

        if(!flags[0].equals("-")) {
            throw new IllegalArgumentException(INVALID_OPTION);
        }
        for (int i = 0 ; i < flags.length ; i++) {
            if (i == 0) continue;
            if (!FLAGS.contains(flags[i])) {
                throw new IllegalArgumentException(INVALID_OPTION);
            }
        }
    }
}
