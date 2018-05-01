## Mototerm

This is a java utility to execute command on mototerm.exe and read the logs the logs to post in implemented repository.

### Prerequisite

- java8
- eclipse

## API walk through

### CmdExecutor.java

This is the core java class containing the process method to start the mototerm.exe execution with specified commands.

Currently this utility is printing all the logs on console using `ConsoleRepository.java` implementation of `Repository.java`.

### Test.java [main]

This java class containing the main method to kick of the execution of this utility.

```java
List<String> commands = new ArrayList<>();
List<String> commandsEvents = new ArrayList<>();

commandsEvents.add(""); commands.add("connect");

CmdExecutor cmd = new CmdExecutor(commandsEvents, commands, "path_to_mototerm.exe", "30.128.98.144");
cmd.process();
```

### Repository.java [Interface]

Containing ` void write(String log)` method prototype.

### ConsoleRepository.java

`ConsoleRepository implements Repository`

Implementation of `Repository.java` to print the logs on console.

## How to execute

Pass the `Repository` implementation and commands to execute on `mototerm.exe`, and execute the `Test.main` method.