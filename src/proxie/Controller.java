package proxie;
import Commands.BlockCommand;
import Commands.PrintCommand;
import Commands.UnblockCommand;
import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);

    public void run() {

        while (true) {
            try {
                System.out.println("please enter b | u | p | q | d");
                String userInput =  scanner.next().trim();

                if (userInput.equals("q")) break;

                //will be change to array of commands for all the kinds of command - loop on array of commands
                switch (userInput) {
                    case "p":
                        PrintCommand wantedCommand3 = new PrintCommand();
                        wantedCommand3.execute();
                        break;
                    case "b":
                        BlockCommand wantedCommand = new BlockCommand(scanner.nextLine().trim());
                        wantedCommand.execute();
                        break;
                    case "u":
                        UnblockCommand wantedCommand2 = new UnblockCommand(scanner.nextLine().trim());
                        wantedCommand2.execute();
                        break;
                    case "d":
                        // Handle input d - the parameter will be:: scanner.nextLine().trim().split(" ", 2);
                        break;
                    default:
                        break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}