package com.nitesh.adt.util;

/**
 * 
 * @author nitesh
 *
 * @param <T>
 */
public interface Collection<T> extends Iterable<T> {
	void add(T t);

	void addAll(T[] values);

	boolean contains(T t);

	boolean remove(T t);

	Iterator<T> iterator();

	void clear();

	boolean isEmpty();
}
