package com.binaryTree;

public interface BinaryTree<X extends Comparable<X>> {
    int size();

    boolean contains(X item);

    boolean delete(X item);

    void add(X item);
}
