package com.design.pattern.command;

public class CommandSwitch {
	public CommandSwitch(Command upCommand, Command downCommand) {
		super();
		this.upCommand = upCommand;
		this.downCommand = downCommand;
	}

	Command upCommand, downCommand;
	
	public void flipUp(){
		upCommand.execute();
	}
	
	public void flipDown(){
		downCommand.execute();
	}
}
