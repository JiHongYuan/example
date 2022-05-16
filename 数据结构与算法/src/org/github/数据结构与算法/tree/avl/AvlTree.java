package org.github.数据结构与算法.tree.avl;


import org.github.数据结构与算法.tree.AbstractTree;

/**
 * @author JiHongYuan
 * @date 2021/6/17 17:51
 */
public class AvlTree extends AbstractTree<AvlTree.Node> {

    public static class Node extends AbstractTree.Node<Node> {
        int height;

        public Node(Integer value, Node left, Node right) {
            super(value, left, right);
        }
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    @Override
    public void insert(int value) {
        root = insert(root, value);
    }

    public Node get(Integer value) {
        return node(root, value);
    }

    /**
     * return specified element value.
     */
    Node node(Node node, Integer value) {
        if (value < node.value) {
            return node(node.left, value);
        } else if (value > node.value) {
            return node(node.right, value);
        } else {
            return node;
        }
    }

    private Node singleRotateWithLeft(Node k2) {
        Node k1;
        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        return k1;
    }

    private Node singleRotateWithRight(Node k2) {
        Node k1;

        k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;

        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        return k1;
    }

    private Node doubleRotateWithLeft(Node k3) {
        k3.left = singleRotateWithRight(k3.left);
        return singleRotateWithLeft(k3);
    }

    private Node doubleRotateWithRight(Node k3) {
        k3.right = singleRotateWithLeft(k3.right);
        return singleRotateWithRight(k3);
    }

    private Node insert(Node node, Integer value) {
        if (node == null) {
            node = new Node(value, null, null);
        } else if (value < node.value) {
            // 插入在左边
            node.left = insert(node.left, value);

            // 找到破坏平衡的节点
            if (height(node.left) - height(node.right) == 2) {
                if (value < node.left.value) {
                    // 左左条件 单旋转
                    node = singleRotateWithLeft(node);
                } else {
                    // 左右条件 双旋转
                    node = doubleRotateWithLeft(node);
                }
            }
        } else if (value > node.value) {
            node.right = insert(node.right, value);
            if (height(node.right) - height(node.left) == 2) {
                if (value > node.right.value) {
                    node = singleRotateWithRight(node);
                } else {
                    node = doubleRotateWithRight(node);
                }
            }
        }
        // 重新计算节点高度
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

}
