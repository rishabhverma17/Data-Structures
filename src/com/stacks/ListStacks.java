package com.stacks;

import java.util.ArrayList;

public class ListStacks<X> implements Stack {
    private ArrayList<X> listStack = new ArrayList<>();
    private int stackPointer;

    @Override
    public void push(Object newItem) {
        listStack.add((X)newItem);
        stackPointer++;
    }

    @Override
    public Object pop() {
        if(stackPointer == 0){
            throw new IllegalStateException("Stack is empty.");
        }
        X result =  listStack.get(--stackPointer);
        listStack.remove(stackPointer);
        //stackPointer--;
        return result;
    }

    @Override
    public boolean contains(Object searchedItem) {
        boolean isExist = false;
        if(listStack.contains((X)searchedItem)){
            isExist =  true;
        }
        return isExist;
    }

    @Override
    public Object access(Object requesteditem) {
        if(listStack.contains((X)requesteditem)){
            int index = listStack.indexOf((X)requesteditem);
            return listStack.get(index);
        }
        throw new IllegalArgumentException("Item "+requesteditem+" does not exist in stack");
    }

    @Override
    public int size() {
        return listStack.size();
    }
}
