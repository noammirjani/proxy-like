/**
 * The Controller class implements a simple command line interface for executing commands.
 * It contains a HashMap of available commands and maps user inputs to those commands.
 * The user can enter "b", "u", "p", "d", or "q" to execute different commands.
 */
package proxie;

import Commands.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Controller {

    // Scanner object for reading user input
    Scanner scanner = new Scanner(System.in);

    // HashMap to store available commands
    private final Map<String, Command> CommandsMenu = new HashMap<>();

    /**
     * Constructor for the Controller class.
     * Initializes the available commands in the CommandsMenu HashMap.
     */
    public Controller(){
        setCommandsMenu();
    }

    /**
     * Initializes the available commands in the CommandsMenu HashMap.
     * Maps "b" to BlockCommand, "u" to UnblockCommand, "p" to PrintCommand, and "d" to DownloadCommand.
     */
    private void setCommandsMenu(){
        CommandsMenu.put("b", new BlockCommand());
        CommandsMenu.put("u", new UnblockCommand());
        CommandsMenu.put("p", new PrintCommand());
        CommandsMenu.put("d", new DownloadCommand());
        CommandsMenu.put("q", new QuitCommand());
    }

    /**
     * Runs the command line interface.
     * Prompts the user to enter a command and reads user input.
     * If the input is "q", exits the loop and terminates the program.
     * If the input matches a valid command, executes the command with user-specified data.
     * If the input does not match a valid command, throws an IllegalArgumentException with the message "Invalid command".
     * If an exception occurs during command execution, prints the error message.
     */
    public void run() {
        while (true) {
            try {
                System.out.println("please enter b | u | p | q | d");
                String userInput =  scanner.next().trim();

                Command command = CommandsMenu.get(userInput);
                if (command == null) {
                    scanner.nextLine();
                    throw new IllegalArgumentException("Invalid command");
                }

                String data = scanner.nextLine().trim();
                command.execute(data);
                if (userInput.equals("q")) break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
