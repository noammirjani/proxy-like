package Commands;

public class QuitCommand implements Command{
    private static final int NUM_OF_PARAMETERS = 0;
    public QuitCommand(){}

    @Override
    public void execute(String data){

        Validations.numOfParameters(data.split("").length, NUM_OF_PARAMETERS);
    }
}
