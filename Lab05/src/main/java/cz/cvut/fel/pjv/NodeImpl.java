/*
 *  File name:  NodeImpl
 *  Date:       8.3.17
 *  Author:     Lukas Forst
 *  Package:    cz.cvut.fel.pjv
 *  Project:    Lab05
 */

package cz.cvut.fel.pjv;

public class NodeImpl implements Node {
    private Node left;
    private Node right;
    private int value;

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public Node getLeft() {
        return left;
    }

    @Override
    public Node getRight() {
        return right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

}

