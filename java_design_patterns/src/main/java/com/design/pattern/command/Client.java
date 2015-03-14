package com.design.pattern.command;

public class Client {

	public static void main(String[] args) {
		IntendAction ia = new IntendAction();
		CommandActionA ca = new CommandActionA(ia);
		CommandActionB cb = new CommandActionB(ia);
		CommandSwitch cs = new CommandSwitch(ca, cb);
		cs.flipUp();
		cs.flipDown();

	}
}
