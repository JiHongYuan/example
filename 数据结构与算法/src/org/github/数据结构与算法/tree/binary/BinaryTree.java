package org.github.数据结构与算法.tree.binary;


import org.github.数据结构与算法.tree.AbstractTree;


/**
 * @author JiHongYuan
 * @date 2021/6/27 20:35
 */
public class BinaryTree extends AbstractTree<BinaryTree.Node> {

    @Override
    public void insert(int value) {
        root = insert(root, value);
    }

    public Node find(int val) {
        return find(root, val);
    }

    public boolean delete(int val) {
        delete(root, val);
        return true;
    }


    public static class Node extends AbstractTree.Node<Node> {
        public Node(Integer value) {
            super(value);
        }
    }

    private Node insert(Node head, int val) {
        if (head == null) {
            head = new Node(val);
        }
        if (val < head.value) {
            head.left = insert(head.left, val);
        } else if (val > head.value) {
            head.right = insert(head.right, val);
        }
        return head;
    }

    private Node find(Node node, int val) {
        if (node == null) {
            return null;
        }

        if (val < node.value) {
            return find(node.left, val);
        } else if (val > node.value) {
            return find(node.right, val);
        } else {
            return node;
        }
    }

    private Node delete(Node node, int k) {
        if (k < node.value) {
            node.left = delete(node.left, k);
        } else if (k > node.value) {
            node.right = delete(node.right, k);
        } else if (node.left != null && node.right != null) {
            // 一般删除策略是用其右字树的最小的数据代替删除的那个节点
            Node minNode = findMin(node.right);
            node.value = minNode.value;
            node.right = delete(node.right, node.value);
        } else if (node.left == null) {
            node = node.right;
        } else {
            node = node.left;
        }
        return node;
    }

    private Node findMin(Node node) {
        if (node.left == null) return node;
        return findMin(node.left);
    }

}
