# C-- Compiler

## Dependencies

- Java minimum version 19
  - [Download latest](https://www.oracle.com/europe/java/technologies/downloads/#jdk24-mac)
- Install [mono](https://www.mono-project.com/docs/getting-started/install/mac/)

## Running

To quickly compile changes and test the output, run (this will only work on MacOS). This already runs the code with the jars.
```
sh compile_and_run.sh
```

If running on IntelliJ, the .idea folder should automatically define the dependencies, and you can just run one of the entry point classes.

## Entry points definitions

1. [Main](./src/Main.java) class. Runs the compiler with no debug information, receiving the input and output file names as parameters (e.g., input.txt output.txt).
2. [MainIntrospector](./src/MainIntrospector.java) class. Like the previous one, but also shows the AST in a graphic window, using the Introspector tool. This is a useful tool to check the correct implementation of the language (the AST created for the input program).
3. [TestRigGUI](./src/TestRigGUI.java) class. Shows the parse tree of the input.txt source program (useful when developing the parsers).
4. [TestRigTokens](./src/TestRigTokens.java) class. Shows the tokens recognized in the input.txt source program (useful when developing the lexer).
5. [TestRigTrace](./src/TestRigTrace.java) class. Displays how the syntax rules are derived in the parser, when the input.txt file is being parsed (a tool to debug the parser implementation).

## Input/output

By default, the input file is defined as [input.txt](./input.txt) and the output is [output.txt](./output.txt)