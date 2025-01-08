import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Print the shell prompt
            System.out.print("$ ");

            // Read user input
            String input = scanner.nextLine();

            // Handle the `exit` builtin command
            if (input.startsWith("exit")) {
                // Extract the exit code from the command
                String[] parts = input.split(" ");
                int exitCode = 0; // Default exit code
                if (parts.length > 1) {
                    try {
                        exitCode = Integer.parseInt(parts[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("exit: invalid exit code");
                        continue;
                    }
                }
                // Exit with the given code
                System.exit(exitCode);
            }

            // Handle the `echo` builtin command
            if (input.startsWith("echo")) {
                // Extract and print the text after "echo"
                String[] parts = input.split(" ", 2);
                if (parts.length > 1) {
                    System.out.println(parts[1]);
                } else {
                    System.out.println();
                }
                continue;
            }

            // Print error message for invalid commands
            System.out.println(input + ": command not found");
        }
    }
}
