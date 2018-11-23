package com.base.btree;

public class TreeContainer {

	private Node base;

	public Node getBase() {
		return base;
	}

	public void setBase(Node base) {
		this.base = base;
	}

	void insertNode(Node input) {
		if (base == null) {
			input.setPosition(1);
			base = input;
		} else {
			insertOnFeederNode(input, base);
		}
	}
	
	void insertOnFeederNode(Node input, Node feeder){
		
		if(feeder.getData()>input.getData()) {
			if(feeder.getLeft()==null) {
				input.setPosition(feeder.getPosition()*2);
				feeder.setLeft(input);
			}else {
				insertOnFeederNode(input, feeder.getLeft());
			}
		} else {
			if(feeder.getRight()==null) {
				input.setPosition((feeder.getPosition()*2)+1);
				feeder.setRight(input);
			}else {
				insertOnFeederNode(input, feeder.getRight());
			}
		}
	}

	
}
