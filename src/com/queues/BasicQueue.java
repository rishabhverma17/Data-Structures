package com.queues;

public class BasicQueue<X> implements Queue<X> {
    private X[] data;
    private int front;
    private int end;

    public BasicQueue(){
        this.data = (X[]) new Object[1000];
        this.front = -1;
        this.end = -1;
    }

    @Override
    public int size(){
        if(front == -1 && end == -1){
            return 0;
        }
        else{
            return (end - front) + 1;
        }
    }

    @Override
    public void enQueue(X item){
        // Check if Queue is full
        if((end+1) % data.length == front){
            throw new IllegalStateException("Queue is Full.");
        }
        // Case when queue is empty.
        else if(size() == 0){
            front++;
            data[++end] = item;
        }
        // Case when queue has at least one elements present.
        else{
            data[++end] = item;
        }
    }

    @Override
    public X deQueue(){
        X deQueuedElement = null;
        // Case when queue is empty.
        if(size() == 0){
            throw new IllegalStateException("Queue is Empty");
        }
        // Case when queue has only one element in it.[Reset the Queue to original state]
        else if(front == end){
            deQueuedElement = data[front];
            data[front] = null;
            front = -1;
            end = -1;
        }
        // Case when queue has element
        else{
            deQueuedElement = data[front];
            data[front] = null;
            front++;
        }
        return deQueuedElement;
    }

    @Override
    public boolean contains(X item){
        boolean isPresent = false;
        int counter = front;
        if(size() == 0){
            return isPresent;
        }
        while(counter != end-1){
            if(data[counter] == item){
                isPresent = true;
                break;
            }
            counter++;
        }
        return isPresent;
    }

    @Override
    public X access(int position){
        if(size() == 0 || position > size()){
            throw new IllegalStateException("Either Queue is Empty or position passed is greater than size of queue.");
        }
        for(int i=front; i<end; i++){
            if(i == position){
                return data[i];
            }
        }
        throw new IllegalStateException("Could not find position "+position+" in queue.");
    }
}
