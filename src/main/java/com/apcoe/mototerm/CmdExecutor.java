package com.apcoe.mototerm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * <p>
 * {@code CmdExecutor} can execute bat or exe file through command prompt interactively.
 * 
 * <p>
 * Specify the commands with respect to command events.
 * 
 * @author Rahul Vishvakarma
 *
 */
public class CmdExecutor {

	private List<String> commands;
	
	private List<String> commandsEvents;
	
	private BufferedReader reader;
	
	private BufferedWriter writer;
	
	private volatile String oldLine = "";
	
	private ProcessBuilder builder;
	
	private Process process;
	
	private int currentCommandIndex = 0;
	
	private Repository repository;
	
	/**
	 * Instance of {@link CmdExecutor}
	 * 
	 * To start the execution call {@link CmdExecutor#process()} method.
	 * 
	 * @param commandsEvents - {@link List} of command events
	 * @param commands - {@link List} of commands
	 * @param args - arguments used to start execution
	 * @throws IOException IO Error
	 */
	public CmdExecutor(Repository repository, List<String> commandsEvents, List<String> commands, String... args) throws IOException {
		
		this.repository = repository;
		
		this.commands = commands;
		this.commandsEvents = commandsEvents;
		
		this.builder = new ProcessBuilder(args);
		this.builder.redirectErrorStream(true);
	}
	
	/**
	 * <p>
	 * Start the execution.
	 * 
	 * <p>
	 * In Future version it may ask to configure repository to dump the execution logs.
	 * 
	 */
	public void process() {

		try {
			process = builder.start();
			InputStream is = process.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is));
			
			OutputStream out = process.getOutputStream();
			writer = new BufferedWriter(new OutputStreamWriter(out));
			
			try {
				new Thread(executeCommands).start();
				Thread.sleep(500);
				while (oldLine != null) {
					oldLine = reader.readLine();
					this.repository.write(oldLine);
				}
				
			} finally {
				writer.close();
				reader.close();
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
	
	}
	
	private Runnable executeCommands = ()  -> {
		try {
			
			this.writer.write("connect");
			this.writer.newLine();
			this.writer.flush();
			System.err.printf("connect\n");
			
			while(true) {
				Thread.sleep(20000);
				this.writer.write("osdiag HeapInfo");
				this.writer.newLine();
				this.writer.flush();
				System.err.printf("osdiag HeapInfo\n");
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	};
}