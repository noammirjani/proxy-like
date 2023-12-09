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
    }

    public void printMenu() {
        System.out.println("Available Commands:");
        System.out.println("b : Blocks a URL and adds it to the list of blocked URLs saved to the file.");
        System.out.println("u : Unblocks a URL and updates the list.");
        System.out.println("p : Prints the current list of blocked sites alphabetically ordered.");
        System.out.println("q : Exits the program.");
        System.out.println("d <-options> : Downloads the contents of the given URL to a file, applying the specified denying options.");
        System.out.println("  Possible flags: i: Blocks images, c: Blocks HTTP cookies, h: Blocks HTML documents, b: Denies access to blocked sites.");
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
        printMenu();
        while (true) {
            try {
                String operation = scanner.next().trim();
                String[] userInput =  scanner.nextLine().trim().split("\\s+");


                if (operation.equals("q") && userInput[0].equals("")) break;
                Command command = CommandsMenu.get(operation);
                if (command == null) {
                    throw new IllegalArgumentException("Invalid command");
                }

                command.execute(userInput);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
