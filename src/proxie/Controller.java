package proxie;
import Commands.*;
import FileManager.FileManage;

import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    private Map<String, Command> CommandsMenu = new HashMap<>();

    public Controller(){

        setCommandsMenu();
    }

    private void setCommandsMenu(){
        CommandsMenu.put("b", new BlockCommand());
        CommandsMenu.put("u", new UnblockCommand());
        CommandsMenu.put("p", new PrintCommand());
        CommandsMenu.put("d", new DownloadCommand());
    }

    public void run() {

        while (true) {
            try {
                System.out.println("please enter b | u | p | q | d");
                String userInput =  scanner.next().trim();

                if (userInput.equals("q")) break;

                Command command = CommandsMenu.get(userInput);
                if (command == null) {
                    scanner.nextLine();
                    throw new IllegalArgumentException("Invalid command");
                }

                String data = scanner.nextLine().trim();
                command.execute(data);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                }
            }
        }
    }