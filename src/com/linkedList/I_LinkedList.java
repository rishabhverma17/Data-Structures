package com.linkedList;

public interface I_LinkedList<X> {
    int size();

    void add(X item);

    X remove();

    void insert(X item, int position);

    X removeAt(int position);

    X get(int position);

    int find(X item);

    @Override
    String toString();
}
