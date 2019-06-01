package com.binaryTree;

public class BasicBinaryTree<X extends Comparable<X>> implements BinaryTree<X> {
    private Node root;
    private int size;

    public BasicBinaryTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(X item) {
        Node currentNode = getNode(item);
        if (currentNode != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(X item) {
        boolean deleted = false;
        if (this.root == null) {
            return false;
        }
        Node currentNode = getNode(item);

        if (currentNode != null) {
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                unLink(currentNode, null);
                deleted = true;
            } else if (currentNode.getLeft() == null && currentNode.getRight() != null) {
                unLink(currentNode, currentNode.getRight());
                deleted = true;
            } else if (currentNode.getLeft() != null && currentNode.getRight() == null) {
                unLink(currentNode, currentNode.getLeft());
                deleted = true;
            }
            // When parent node which has to be deleted has both left and right node
            else {
                // Swap the node with rightmost leaf node on the left side.
                Node child = currentNode.getLeft();
                while (child.getRight() != null && child.getLeft() != null) {
                    child = child.getRight();
                }

                // We have rightmost leaf node. We can replace the current node with this node.
                child.getParent().setRight(null); // Remove the leaf node from its current position.

                child.setLeft(currentNode.getLeft());
                child.setRight(currentNode.getRight());

                unLink(currentNode, child);
                deleted = true;
            }
        }
        if (deleted) {
            size--;
        }
        return deleted;
    }

    private void unLink(Node currentNode, Node newNode) {
        if (currentNode == this.root) {
            newNode.setLeft(currentNode.getLeft());
            newNode.setRight(currentNode.getRight());
            this.root = newNode;
        } else if (currentNode.getParent().getRight() == currentNode) {
            currentNode.getParent().setRight(newNode);
        } else {
            currentNode.getParent().setLeft(newNode);
        }
    }

    private Node getNode(X item) {
        Node currentNode = this.root;
        while (currentNode != null) {
            int val = item.compareTo((X) currentNode.getItem());
            if (val == 0) {
                return currentNode;
            } else if (val < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }
        return null;
    }

    @Override
    public void add(X item) {
        Node node = new Node(item);

        if (root == null) {
            this.root = node;
            System.out.println("Set Root = " + node.getItem());
            this.size++;
        } else {
            insert(this.root, node);
        }
    }

    private void insert(Node parent, Node child) {
        // Checking if item is less than parent.
        if (child.getItem().compareTo(parent.getItem()) < 0) {
            if (parent.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                size++;
            } else {
                insert(parent.getLeft(), child);
            }
        } else if (child.getItem().compareTo(parent.getItem()) > 0) {
            if (parent.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                size++;
            } else {
                insert(parent.getRight(), child);
            }
        } else if (child.getItem().compareTo(parent.getItem()) == 0) {
            throw new IllegalArgumentException("Duplicates not allowed. " + child.getItem() + " Already Exists in BinaryTree.");
        }
    }
}
