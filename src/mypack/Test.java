package mypack;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws Exception {
		
		Repository repo = new ConsoleRepository();
		
		List<String> commands = new ArrayList<>();
		List<String> commandsEvents = new ArrayList<>();
		
		commandsEvents.add(""); commands.add("connect");
		
		CmdExecutor cmd = new CmdExecutor(repo, commandsEvents, commands
						, "D:\\project\\Zodiac\\mototerm.exe", "30.128.98.144");
		cmd.process();
	}
}