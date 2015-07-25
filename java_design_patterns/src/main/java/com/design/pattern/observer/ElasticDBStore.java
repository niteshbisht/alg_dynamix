package com.design.pattern.observer;

import java.util.Iterator;
import java.util.Vector;

public class ElasticDBStore implements Subject {

	private Vector<Observer> observerVectr;
	private String operation;
	private String record;

	/**
	 * 
	 */
	public ElasticDBStore() {
		super();
		this.observerVectr = new Vector<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		this.observerVectr.add(o);

	}

	@Override
	public void notifyObservers() {
		Iterator<Observer> itr = this.observerVectr.iterator();
		for (; itr.hasNext();) {
			Observer o = itr.next();
			o.update(this.operation, this.record);
		}
	}

	@Override
	public void removeObserver(Observer o) {
		this.observerVectr.remove(o);
	}

	public void editRecords(String operation, String record) {
		this.operation = operation;
		this.record = record;
		notifyObservers();
	}

}
