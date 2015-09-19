package com.javabase.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class HashExplorer<K, V> {

	static final int MAXIMUM_CAPACITY = 1 << 30;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	static final float DEFAULT_LOAD_FACTOR = 0.75f;
	transient Node<K, V>[] table;
	int threshold;
	final float loadFactor = 0.75f;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> baseMap = new HashMap<Integer, String>();
		for (int p = 0; p < 50000; p++) {
			baseMap.put(p, "j + " + p);
		}
		System.out.println(baseMap.size());
		System.out.println(baseMap.toString());

	}

	static class Node<K, V> implements Map.Entry<K, V> {
		final int hash;
		final K key;
		V value;
		Node<K, V> next;

		Node(int hash, K key, V value, Node<K, V> next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public final K getKey() {
			return key;
		}

		public final V getValue() {
			return value;
		}

		public final String toString() {
			return key + "=" + value;
		}

		public final int hashCode() {
			return Objects.hashCode(key) ^ Objects.hashCode(value);
		}

		public final V setValue(V newValue) {
			V oldValue = value;
			value = newValue;
			return oldValue;
		}

		public final boolean equals(Object o) {
			if (o == this)
				return true;
			if (o instanceof Map.Entry) {
				Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
				if (Objects.equals(key, e.getKey())
						&& Objects.equals(value, e.getValue()))
					return true;
			}
			return false;
		}
	}

	int hash(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	}

}
