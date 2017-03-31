/*
 *  File name:  Start
 *  Date:       8.3.17
 *  Author:     Lukas Forst
 *  Package:    cz.cvut.fel.pjv
 *  Project:    Lab05
 */

package cz.cvut.fel.pjv;

public class Start {

    public static void main(String[] args) {
        new Start().tree();
//        int a = 1/2;
//        System.out.println(a);
    }

    private void tree(){
        TreeImpl tree = new TreeImpl();
        //int[] array = {0,1,2,3,4,5};
        int[] array = {1,2,3,4,5,6,7};
        tree.setTree(array);
        System.out.println(tree.toString());
    }
}
