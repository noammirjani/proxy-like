package proxie;
import java.util.Scanner;

public class Controller {

    static Scanner scanner = new Scanner(System.in);

    public void Controller(){}

    public void run(){

        while(true){
            String[] userInput = getData();

            if(userInput[0].trim().equals("q")) break;

            try{

            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private String[] getData(){
        String data =  scanner.nextLine();
        return data.split(" ");
    }
}