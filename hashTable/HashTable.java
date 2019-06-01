package com.hashTable;

public interface HashTable<X, Y> {
    int size();

    Y get(X key);

    void put(X key, Y value);

    Y delete(X key);

    boolean hasKey(X key);

    boolean hasValue(Y value);
}
