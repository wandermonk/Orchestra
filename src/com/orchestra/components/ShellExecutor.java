package com.orchestra.components;

import java.io.IOException;

public class ShellExecutor {
	
	private String[] command;
	
	private ProcessBuilder processbuilder;
	
	public ShellExecutor(String[] command){
		this.command = command;
		processbuilder = new ProcessBuilder(command);
	}
	
	public int executorWithWait() throws InterruptedException, IOException{
		int exitStatus = processbuilder.inheritIO().start().waitFor();
		return exitStatus;
	}
	
	public Process executorWithoutWait() throws IOException {
		Process spawnProcess = processbuilder.inheritIO().start();
		return spawnProcess;
	}

	
}
