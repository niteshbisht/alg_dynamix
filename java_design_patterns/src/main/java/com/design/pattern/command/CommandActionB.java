package com.design.pattern.command;

public class CommandActionB implements Command {

	IntendAction ia;

	public CommandActionB(IntendAction ia) {
		this.ia = ia;
	}

	@Override
	public void execute() {
		ia.lightOff();
	}
}