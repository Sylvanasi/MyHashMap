package com.mydemo.map;

public interface MyMap<K,V> {
    V put(K key,V value);

    V get(K key);

    interface MyEntry<K,V>{
        K getKey();

        V getValue();
    }
}
