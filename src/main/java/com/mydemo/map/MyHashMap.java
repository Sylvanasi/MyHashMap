package com.mydemo.map;

public class MyHashMap<K,V> implements MyMap<K,V>{

    private int size;

    private int CAPACITY = 8;

    private MyEntry[] table = new MyEntry[CAPACITY];


    private int hash(K key){
        return key == null ? 0 : (key.hashCode() >>> 16)%CAPACITY;
    }


    @Override
    public V put(K key, V value) {
        int hash = hash(key);
        MyEntry<K,V> e = null;
        for(MyEntry<K,V> entry = table[hash] ; entry != null ; entry = entry.next ){
            if(hash(entry.getKey()) == hash && key.equals(entry.getKey())){
                entry.setValue(value);
                return entry.getValue();
            }
            e = entry;
        }
        MyEntry<K,V> newEntry = new MyEntry<K,V>(key,value,null);
        e.next = newEntry;
        return newEntry.getValue();
    }

    @Override
    public V get(K key) {
        int hash = hash(key);
        MyEntry<K,V> e = null;
        for(MyEntry<K,V> entry = table[hash] ; entry != null ; entry = entry.next ){
            if(hash(entry.getKey()) == hash && key.equals(entry.getKey())){
                return entry.getValue();
            }
        }

        return null;
    }

    class MyEntry<K,V> implements MyMap.MyEntry<K,V>{

        K key;
        V value;
        MyEntry<K,V> next;

        public MyEntry(K key, V value, MyEntry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public MyEntry(K key, V value) {
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

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public void setKey(K key) {
            this.key = key;
        }

    }
}
