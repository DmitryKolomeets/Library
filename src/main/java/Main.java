
import enums.Commands;

import service.CommandService;

import java.util.*;
import java.util.function.Consumer;

public class Main {
    private final static Map<String, Consumer<Scanner>> commands = new HashMap();
    private final static CommandService commandService = new CommandService();


    static {
        initializer();

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter Your name: ");
        String command = scanner.nextLine().toLowerCase();

        System.out.println("Enter help to print Help commands: ");

        while (!command.equals("exit")) {
            command = scanner.nextLine().toLowerCase();
            commands.getOrDefault(command, scanner1 -> System.out.println("incorrect command\n"))
                    .accept(scanner);
        }


    }


    private static void initializer() {

        commands.put(Commands.HELP.value, commandService.Help());
        commands.put(Commands.EXIT.value, commandService.exit());
        commands.put(Commands.SHOW.value, commandService.showAllBooks());
        commands.put(Commands.ADD.value, commandService.addBook());
        commands.put(Commands.DELETE.value, commandService.delete());
        commands.put(Commands.ADDNEWUSER.value, commandService.addUser());
        commands.put(Commands.SHOWUSER.value, commandService.showUsersList());


    }
}





