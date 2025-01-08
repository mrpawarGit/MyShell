import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prompt = "$ ";

        while (true) {
            // Print the prompt and read user input
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            // Split the input into command and arguments
            String[] tokens = input.split("\\s+");
            if (tokens.length == 0 || tokens[0].isEmpty()) {
                continue; // Skip empty input
            }

            String command = tokens[0];
            String[] arguments = new String[tokens.length - 1];
            System.arraycopy(tokens, 1, arguments, 0, tokens.length - 1);

            // Handle built-in commands
            if ("exit".equals(command)) {
                break; // Exit the shell
            } else if ("echo".equals(command)) {
                System.out.println(String.join(" ", arguments));
            } else if ("type".equals(command)) {
                handleTypeCommand(arguments);
            } else if ("pwd".equals(command)) {
                handlePwdCommand();
            } else {
                // Execute external commands
                executeExternalCommand(command, arguments);
            }
        }

        scanner.close();
    }

    private static void handlePwdCommand() {
        // Print the current working directory
        String currentDir = System.getProperty("user.dir");
        System.out.println(currentDir);
    }

    private static void handleTypeCommand(String[] arguments) {
        if (arguments.length != 1) {
            System.out.println("Usage: type <command>");
            return;
        }

        String cmd = arguments[0];
        if ("exit".equals(cmd) || "echo".equals(cmd) || "type".equals(cmd) || "pwd".equals(cmd)) {
            System.out.println(cmd + " is a shell builtin");
        } else {
            String executablePath = findExecutableInPath(cmd);
            if (executablePath != null) {
                System.out.println(cmd + " is " + executablePath);
            } else {
                System.out.println(cmd + ": not found");
            }
        }
    }

    private static String findExecutableInPath(String command) {
        String pathEnv = System.getenv("PATH");
        if (pathEnv == null) {
            return null;
        }

        String[] paths = pathEnv.split(":");
        for (String path : paths) {
            java.io.File file = new java.io.File(path, command);
            if (file.exists() && file.canExecute()) {
                return file.getAbsolutePath();
            }
        }
        return null;
    }

    private static void executeExternalCommand(String command, String[] arguments) {
        try {
            String[] fullCommand = new String[1 + arguments.length];
            fullCommand[0] = command;
            System.arraycopy(arguments, 0, fullCommand, 1, arguments.length);

            ProcessBuilder pb = new ProcessBuilder(fullCommand);
            pb.inheritIO();
            Process process = pb.start();
            process.waitFor();
        } catch (IOException e) {
            System.out.println(command + ": command not found");
        } catch (InterruptedException e) {
            System.out.println("Execution interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}
