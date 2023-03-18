package proxie;
import FileManager.FileManagment;

import java.util.Scanner;

public class Controller {

    static Scanner scanner = new Scanner(System.in);
    static final String BLOCKED_FILE_NAME = "blocked.txt";

    public void Controller(){
        FileManagment blockedUrlFile = new FileManagment();

    }

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