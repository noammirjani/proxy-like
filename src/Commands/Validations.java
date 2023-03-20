package Commands;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class Validations {
    private static final String INVALID_URL = "invalid URL";
    private static final String INVALID_COMMAND = "invalid command";
    private static final String INVALID_OPTION = "invalid option";
    private static final List<String> FLAGS = List.of("b","c","h","i");

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

    public static void noneParameterCommand (String parameters){
        if(!parameters.equals("")){
            throw new IllegalArgumentException(INVALID_COMMAND);
        }
    }


    public static void checkOptions(String options) {
        System.out.println(options);
            String[] flags = options.split("(?!^)");
            if(!flags[0].equals("-")) {
                throw new IllegalArgumentException(INVALID_OPTION);
            }
        for (int i = 0 ; i < flags.length ; i++) {
            if (i == 0) continue;
            if (!FLAGS.contains(flags[i])) {
                throw new IllegalArgumentException(INVALID_OPTION);
            }
//            for (String flag : flags) {
//                if (!FLAGS.contains(flag) && !flag.equals("-")) {
//                    throw new IllegalArgumentException(INVALID_OPTION);
//            }
        }
    }
}
