package com.design.pattern.decorator;

public class Disk extends AbstractComputerComponent {

	Computer comp;
	
	/**
	 * @param comp
	 */
	public Disk(Computer comp) {
		super();
		this.comp = comp;
	}

	@Override
	public String description() {
		return comp.description()+" & "+" i am a disk";
	}

}
