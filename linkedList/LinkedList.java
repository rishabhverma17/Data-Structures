package com.linkedList;

public class LinkedList<X> implements I_LinkedList<X> {
    private Node first;
    private Node last;
    private int nodeCount;

    public LinkedList(){
        this.first = null;
        this.last = null;
        this.nodeCount = 0;
    }

    @Override
    public int size(){
        return nodeCount;
    }

    @Override
    public void add(X item){
        Node newNode = new Node(item);
        if(first == null){
            first = newNode;
            last = first;
        }
        else{
            last.setNextNode(newNode);
            last = newNode;
        }
        nodeCount++;
    }
    @Override
    public X remove(){
        if(first == null){
            throw new IllegalStateException("Linked List is Empty");
        }
        X toBeRemoved = (X)first.getNodeData();
        first = first.getNextNode();
        nodeCount--;
        return toBeRemoved;
    }
    @Override
    public void insert(X item, int position){
        Node newNode = new Node(item);
        Node currentNode = first;
        if(position > size()){
            throw new IllegalStateException("Position passed is greater than the size of linked list");
        }
        // Traverse to the position and insert the new node.
        while(position != 0){
            currentNode = currentNode.getNextNode();
            position--;
        }
        newNode.setNextNode(currentNode.getNextNode());
        currentNode.setNextNode(newNode);
        nodeCount++;
    }

    @Override
    public X removeAt(int position){
        if(first == null){
            throw new IllegalStateException("Linked list is empty");
        }
        if(position > nodeCount){
            throw new IllegalStateException("Position passed is greater than the size of linked list");
        }

        Node currentNode = first;
        Node previous = first;
        X data = null;
        // Traverse till passed node.
        while(position != 0 && currentNode != null){
            previous = currentNode;
            currentNode = currentNode.getNextNode();
            position--;
        }
        data = (X)currentNode.getNodeData();
        previous.setNextNode(currentNode.getNextNode());
        nodeCount--;
        return data;
    }

    @Override
    public X get(int position){
        Node currentNode = first;
        if(first == null){
            throw new IllegalStateException("Linked list is empty");
        }
        if(position > nodeCount){
            throw new IllegalStateException("Position passed is greater than the size of linked list");
        }

        X data = null;
        // Traverse till passed position.
        while(position != 0){
            currentNode = currentNode.getNextNode();
            position--;
        }
        data = (X)currentNode.getNodeData();
        return data;
    }
    @Override
    public int find(X item){
        if(first == null){
            throw new IllegalStateException("Linked list is empty");
        }
        Node currentNode = first;
        for(int i=0; i<size() && currentNode != null; i++){
            if(currentNode.getNodeData().equals(item)){
                return i;
            }
            currentNode = currentNode.getNextNode();
        }
        return -1;
    }

    @Override
    public String toString(){
        StringBuffer contents = new StringBuffer();
        Node curNode = first;
        while(curNode != null){
            contents.append(curNode.getNodeData());
            curNode = curNode.getNextNode();

            if(curNode!=null){
                contents.append(", ");
            }
        }
        return contents.toString();
    }
}

