package com.stacks;

public interface Stack<X> {
    void push(X newItem);

    X pop();

    boolean contains(X searchedItem);

    X access(X requesteditem);

    int size();
}
