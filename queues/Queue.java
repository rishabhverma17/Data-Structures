package com.queues;

public interface Queue<X> {
    int size();

    void enQueue(X item);

    X deQueue();

    boolean contains(X item);

    X access(int position);
}
