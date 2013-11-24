package com.beans;

public class ShellCmdBean {
	
	private String commandName;
	private String platform;
	private String output="";
	
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {		
		System.out.println("in bean,command : "+commandName);
		commandName = commandName.substring(commandName.lastIndexOf("$")+1,commandName.length());
		System.out.println("after op, command : "+commandName);						
		this.commandName = commandName;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
}
