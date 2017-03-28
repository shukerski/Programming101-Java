package com.week06.tuesday;

public interface MyMapInterface<K, V> {
	
	public void put(K key, V value);
	public V get(K key);
	public void remove(K key);
	public boolean containsKey(K key);
}
