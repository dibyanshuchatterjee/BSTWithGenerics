
/*
 * SortedStorageSetWithNulls.java
 *
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
 * This class works on implementing a BST
 *
 * @author Muskan Mall
 * @author Dibyanshu
 */

public class SortedStorageSetWithNulls<E extends Comparable<E>> implements StorageInterface<E> {
    int counter = 0;
    private Node<E> root;

    public SortedStorageSetWithNulls() {
        root = null; //initializing root to null in constructor

    }

    public boolean add(E val) {
        /*
         * this function adds values to the tree to make it a BST
         *
         */
        Node<E> temp, ptr;
        temp = new Node<>(); //creating new node
        temp.data = val; //assinging values
        temp.left = null;
        temp.right = null;
        if (val != null) { //checking if null has been passed
            if (root == null) {
                root = temp;
                return true;
            } else { //if not going ahead and adding by the rules of BST
                ptr = root;
                while (true) { //infinite loop to add nodes until null is reached
                    if (val.compareTo(ptr.data) > 0) {
                        if (ptr.right == null) {
                            ptr.right = temp; //assinging to the right subtree
                            return true;
                        } else
                            ptr = ptr.right;
                    } else if (val.compareTo(ptr.data) < 0) {
                        if (ptr.left == null) {
                            ptr.left = temp; //assinging to the left subtree
                            return true;
                        } else
                            ptr = ptr.left;
                    } else {
                        return false;
                    }
                }
            }
        } else { //checking for null input value
            counter++;
            return true;
        }
    }

    public Node<E> myParent;
    public Node<E> currentNode; //stores current node
    public Node<E> prevNode; //stores previous node

    public boolean find(E x) {
        int temp = counter;
        if (x != null) {
            currentNode = root;
            prevNode = root;
            while (currentNode != null) { //iterating until null is found
                int obj = x.compareTo(currentNode.data);
                if (obj == 0) {
                    myParent = prevNode;
                    return true;
                } else if (obj < 0) {
                    prevNode = currentNode;
                    currentNode = currentNode.left;
                } else {
                    prevNode = currentNode;
                    currentNode = currentNode.right;
                }
            }
            myParent = prevNode; //assinging value to parent node
            return false;
        } else {
            return temp != 0;

        }
    }

    @Override
    public boolean includesNull() {
        /*
         * this function checks for the number of distinct elements in a stringreturns true if a null value was added
         */
        //checking if null was added
        return counter > 0;
    }

    public boolean delete(E key) {
        Node<E> focusNode = root;
        Node<E> parent = root;
        if (key != null) {
            boolean isItALeftChild = true; //flag value to check the node to be deleted
            while (key.compareTo(focusNode.data) != 0) {

                parent = focusNode;
                if (key.compareTo(focusNode.data) < 0) {

                    isItALeftChild = true;
                    focusNode = focusNode.left;

                } else {
                    isItALeftChild = false;
                    focusNode = focusNode.right;

                }
                if (focusNode == null)
                    return false;

            }
            if (focusNode.left == null && focusNode.right == null) { //if both left and right child are missing
                if (focusNode == root) {
                    root = null;
                    return true;
                } else if (isItALeftChild) {
                    parent.left = null;
                    return true;
                } else {
                    parent.right = null;
                    return true;
                }
            } else if (focusNode.right == null) {

                if (focusNode == root)
                    root = focusNode.left;
                else if (isItALeftChild)
                    parent.left = focusNode.left;

                else
                    parent.right = focusNode.left;

            } else if (focusNode.left == null) {

                if (focusNode == root)
                    root = focusNode.right;
                else if (isItALeftChild)
                    parent.left = focusNode.right;
                else
                    parent.right = focusNode.right;

            } else {

                Node<E> replacement = getReplacementNode(focusNode); //replacing the nodes
                if (focusNode == root)
                    root = replacement;

                else if (isItALeftChild)
                    parent.left = replacement;

                else
                    parent.right = replacement;

                replacement.left = focusNode.left;

            }

            return true;
        } else {
            if (counter != 0) {
                counter--;
                return true;
            } else {
                return false;
            }
        }
    }

    public Node<E> getReplacementNode(Node<E> replacedNode) {
        /*
         * this function works on getting the replacement after the deletion occurs
         *
         */

        Node<E> replacementParent = replacedNode;
        Node<E> replacement = replacedNode;

        Node<E> focusNode = replacedNode.right;

        while (focusNode != null) {

            replacementParent = replacement;

            replacement = focusNode;

            focusNode = focusNode.left;

        }

        if (replacement != replacedNode.right) {

            replacementParent.left = replacement.right;
            replacement.right = replacedNode.right;

        }

        return replacement;

    }

    public String inorder(Node<E> ptr) {
        /*
         * this function performs an inorder traversal
         *
         */
        if (ptr == null)
            return null;

        return "\t( l: " + (ptr.left == null ? "null" : inorder(ptr.left))
                + " " + ptr.data + "/ r: " +
                (ptr.right == null ? "null" : inorder(ptr.right)) + " )";
    }

    public String toString() {//overriding toString function
        System.out.println();
        return "So many null values = " + counter + inorder(root);

    }

}
