package com.base.java.generics;

public class OrderedPairE<K, V> implements Pair<K, V> {

	private K key;
	private V value;

	/**
	 * @param key
	 * @param value
	 */
	public OrderedPairE(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

}