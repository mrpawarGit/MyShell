# MyShell - Java Shell Emulator

This project is a simple shell emulator written in Java. It simulates a basic shell environment, supporting built-in commands such as `echo`, `pwd`, `type`, and the execution of external commands available in the system's PATH.

## Features

- **Built-in Commands**:
  - `exit`: Exit the shell.
  - `echo <message>`: Print the given message to the console.
  - `pwd`: Display the current working directory.
  - `type <command>`: Check if the command is a shell built-in or an external executable.

- **External Command Execution**:
  - Supports running external commands available in the system's PATH.

- **Interactive Prompt**:
  - Continuously prompts for user input until the `exit` command is entered.

---

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Ensure JDK 8 or higher is installed on your machine.
- **System PATH**: The system's PATH variable should include directories with executable commands.

### Installation

1. Clone or download this repository.
2. Compile the program using the following command:
   ```bash
   javac Main.java
   ```
3. Run the shell emulator:
   ```bash
   java Main
   ```

---

## Usage

1. **Run the program**:
   - Start the shell by running the `java Main` command.
   - The shell will display a prompt (`$`) for user input.

2. **Built-in Commands**:
   - `exit`: Quit the shell.
   - `echo <message>`: Outputs `<message>` to the console.
     ```bash
     $ echo Hello, World!
     Hello, World!
     ```
   - `pwd`: Displays the current working directory.
     ```bash
     $ pwd
     /path/to/current/directory
     ```
   - `type <command>`: Indicates whether a command is built-in or an external executable.
     ```bash
     $ type echo
     echo is a shell builtin
     $ type ls
     ls is /bin/ls
     $ type unknowncommand
     unknowncommand: not found
     ```

3. **Execute External Commands**:
   - Enter any command available in the system's PATH.
     ```bash
     $ ls
     file1.txt file2.txt
     $ java -version
     java version "17.0.1" 2021-10-19 LTS
     ```
