package com.base.btree;

public class Node {

	int data;
	private Node left;
	private Node right;
	private int position;
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
	@Override
	public String toString() {
		return "Node [data=" + data + ", " + (left != null ? "left=" + left + ", " : "")
				+ (right != null ? "right=" + right + ", " : "") + "position=" + position + "]";
	}
}
