package com.stacks;

public class Stacks<X> implements Stack<X> {
    private X[] data;
    private int stackPointer;

    public Stacks(){
        data = (X[])new Object[1000];
        stackPointer = 0;
    }

    @Override
    public void push(X newItem){
        if(!(stackPointer > data.length)){
            data[stackPointer++] = newItem;
        }
        else{
            throw new IllegalStateException("Stack Overflow!!");
        }
    }

    @Override
    public X pop(){
        if(stackPointer != 0) {
            return data[--stackPointer];
        }
        else{
            throw new IllegalStateException("No More Items on stack to pop. STACK UNDERFLOW");
        }
    }

    @Override
    public boolean contains(X searchedItem){
        boolean found = false;

        for(int i = 0; i<stackPointer; i++) {
            if (data[i].equals(searchedItem)){
                found = true;
                break;
            }
        }

        return found;
    }

    @Override
    public X access(X requesteditem){
        while(stackPointer > 0){
            X popped = pop();
            if(requesteditem.equals(popped)){
                return popped;
            }
        }
        throw new IllegalArgumentException("Cannot find "+requesteditem+" in stack.");
    }

    @Override
    public int size(){
        return stackPointer;
    }
}
