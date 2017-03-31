/**
 *  File name:  TreeImpl
 *  Date:       8.3.17
 *  @author:     Lukas Forst
 *  Package:    cz.cvut.fel.pjv
 *  Project:    Lab05
 */

package cz.cvut.fel.pjv;

public class TreeImpl implements Tree {
    private Node root;

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public void setTree(int[] values){
        root = createTree(values, 0, values.length);
    }

    private Node createTree(int[] values, int start, int end){
        if(start > end){
            return null;
        }
        int middleIndex = (start + end) / 2;

        NodeImpl node = new NodeImpl();

        if(start == end){
            return null;
        }

        node.setValue(values[middleIndex]);
        node.setLeft(createTree(values, start, middleIndex));
        node.setRight(createTree(values, middleIndex + 1, end));

        return node;
    }

    @Override
    public String toString() {
        return recursiveString(root, 0);
    }

    private String recursiveString(Node node, int level){
        if(node == null){
            return "";
        }
        String res = "";

        for(int i = 0; i < level; i++){
            res += " ";
        }

        res += "- " + node.getValue() + "\n";
        if(node.getLeft() != null){
            res += recursiveString(node.getLeft(), level + 1);
        }

        if(node.getRight() != null){
            res += recursiveString(node.getRight(), level + 1);
        }
        return res;
    }
}
