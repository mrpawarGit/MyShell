# Build Your Own Shell 🚀

Welcome to the **Build Your Own Shell Challenge**! This project is my attempt to create a custom, POSIX-compliant shell from scratch. If you've ever wondered how shells work under the hood, this repository is for you. Here, you'll find everything from basic command parsing to running builtin commands like `cd` and `pwd`.

## Features
- **Command Execution**: Run external programs directly from the shell.
- **Builtin Commands**: Supports essential commands like:
  - `cd`: Change the current directory.
  - `pwd`: Print the current working directory.
  - `echo`: Print arguments to the terminal.
- **Command Parsing**: Properly parses commands and arguments.
- **Interactive REPL**: A fully functional Read-Eval-Print Loop for executing commands interactively.
- **Error Handling**: Handles invalid commands and syntax errors gracefully.

## How It Works
This shell provides a minimal yet functional interface to interact with the underlying operating system. It uses the following key components:

1. **Input Parsing**: Reads and tokenizes user input.
2. **Builtin Commands**: Identifies and executes supported internal commands.
3. **Process Management**: Executes external programs using system calls like `fork()` and `exec()`.
4. **Error Messages**: Displays informative messages for invalid commands or improper usage.

## Getting Started

### Prerequisites
- A POSIX-compliant system (Linux/MacOS/WSL).
- GCC or another C compiler for building the shell.

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/your-repo-name.git
   cd your-repo-name
   ```
2. Compile the shell:
   ```bash
   gcc -o my_shell shell.c
   ```
3. Run the shell:
   ```bash
   ./my_shell
   ```

### Usage
- Type commands as you would in any other shell and press `Enter`.
- Use builtin commands like `cd`, `pwd`, or `echo`.
- Run external programs like `ls`, `grep`, or `cat`.
- Type `exit` to leave the shell.

## Example
```bash
$ pwd
/home/user/your-repo-name
$ cd ..
$ pwd
/home/user
$ echo "Hello, Shell!"
Hello, Shell!
$ ls
file1.txt  file2.txt  your-repo-name/
$ exit
```

## What I Learned
- Parsing user input and tokenizing commands.
- Implementing a REPL for an interactive shell experience.
- Handling system calls like `fork()`, `exec()`, and `wait()`.
- Managing errors and ensuring a robust command-line interface.

## Contributions
Feel free to fork this repository, create issues, or submit pull requests if you'd like to improve or extend this project. Any feedback or suggestions are welcome!

## License
This project is licensed under the [MIT License](LICENSE).

---

Thank you for checking out this project! 😊 I hope it helps you learn more about the inner workings of shells and inspires you to build something awesome.
