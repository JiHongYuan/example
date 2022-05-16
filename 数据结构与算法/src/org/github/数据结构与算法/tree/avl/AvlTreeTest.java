package org.github.数据结构与算法.tree.avl;

/**
 * @author JiHongYuan
 * @date 2021/6/17 18:24
 */
public class AvlTreeTest {
    public static void main(String[] args) {
        AvlTree avlTree = new AvlTree();
        avlTree.builderTree(5, 4, 6, 7, 8, 11);

        avlTree.printTree();

        System.out.println(avlTree.get(5));
        avlTree.printTree();

    }
}
