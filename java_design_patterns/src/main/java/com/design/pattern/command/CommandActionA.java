package com.design.pattern.command;

public class CommandActionA implements Command {

	IntendAction ia;

	public CommandActionA(IntendAction ia) {
		this.ia = ia;
	}

	@Override
	public void execute() {
		ia.lightOn();
	}
}
