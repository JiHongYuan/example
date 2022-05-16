package org.github.数据结构与算法.tree.binary;


/**
 * @author JiHongYuan
 * @date 2021/3/22 15:18
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.builderTree(6, 2, 8, 1, 4, 3);

        System.out.print("先序打印：");
        binaryTree.printPreorder();
        System.out.println();

        System.out.print("中序打印：");
        binaryTree.printInorder();
        System.out.println();

        System.out.print("后序打印：");
        binaryTree.printPostorder();
        System.out.println();

        binaryTree.printTree();
        binaryTree.delete(2);
        binaryTree.printPreorder();
        System.out.println();

        binaryTree.printTree();

        System.out.println(binaryTree.find(8));
    }
}
