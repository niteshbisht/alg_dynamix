package com.base.java.generics;

public class Game<T> {
	private T elem;

	/**
	 * @param elem
	 */
	public Game(T elem) {
		super();
		this.elem = elem;
	}

	public Game() {
	}

	public T getElem() {
		return elem;
	}

	public void setElem(T elem) {
		this.elem = elem;
	}
}
