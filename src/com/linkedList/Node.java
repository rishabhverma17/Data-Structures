package com.linkedList;

public class Node<X> {
    private X data;
    private Node nextNode;

    public Node(X data){
        this.data = data;
        nextNode = null;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public X getNodeData(){
        return data;
    }
}
