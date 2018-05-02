package com.apcoe.mototerm;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws Exception {
		
		Repository repo = new LoggerRepository();
		
		List<String> commands = new ArrayList<>();
		List<String> commandsEvents = new ArrayList<>();
		
		commandsEvents.add(""); commands.add("connect");
		
		CmdExecutor cmd = new CmdExecutor(repo, commandsEvents, commands
						, args[0], args[1]);
		cmd.process();
	}
}