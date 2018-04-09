package mypack;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws Exception {
		
		List<String> commands = new ArrayList<>();
		List<String> commandsEvents = new ArrayList<>();
		
		commandsEvents.add(""); commands.add("connect");
		
		CmdExecutor cmd = new CmdExecutor(commandsEvents, commands, "D:\\project\\Zodiac\\mototerm.txt_was.exe", "30.128.98.144");
		cmd.process();
	}
}