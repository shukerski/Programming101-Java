package com.week06.tuesday;

public class MyMap<K, V> implements MyMapInterface<K, V> {

	BucketInterface<K, V>[] buckets;
	private double loadFactor; // elementsIn / size
	private int size;

	public MyMap() {
		size = 8;
		loadFactor = 5;
		buckets = new BucketInterface[size];
	}

	@Override
	public void put(K key, V value) {
		int bucketIndex = calculateBucketIndex(key);

		buckets[bucketIndex].add(key, value);
	}

	@Override
	public V get(K key) {
		int bucketIndex = calculateBucketIndex(key);

		return buckets[bucketIndex].get(key);
	}

	@Override
	public void remove(K key) {
		int bucketIndex = calculateBucketIndex(key);
		buckets[bucketIndex].remove(key);
	}

	@Override
	public boolean containsKey(K key) {
		return get(key) != null;
	}

	private int calculateBucketIndex(K key) {
		return key.hashCode() % size;
	}

}
