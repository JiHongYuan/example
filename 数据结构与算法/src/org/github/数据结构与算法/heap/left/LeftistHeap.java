package org.github.数据结构与算法.heap.left;

import org.github.数据结构与算法.tree.AbstractTree;

/**
 * @author JiHongYuan
 * @date 2021/6/27 17:02
 */
public class LeftistHeap extends AbstractTree<LeftistHeap.Node> {
    private TreeUtil treeUtil = new TreeUtil();


    @Override
    public void insert(int value) {
        root = treeUtil.insert1(root, value);
    }

    public LeftistHeap merge(LeftistHeap heap) {
        Node node = treeUtil.merge(root, heap.root);
        LeftistHeap leftistHeap = new LeftistHeap();
        leftistHeap.root = node;
        return leftistHeap;
    }

    public static class Node extends AbstractTree.Node<LeftistHeap.Node> {
        /* null path length */
        public int npl;

        public Node(Integer value, int npl) {
            super(value);
            this.npl = npl;
        }
    }

    static class TreeUtil {
        public Node insert1(Node node, Integer value) {
            Node singleNode = new Node(value, 0);
            return merge(singleNode, node);
        }

        public Node merge(Node h1, Node h2) {
            if (h1 == null) {
                return h2;
            }
            if (h2 == null) {
                return h1;
            }

            if (h1.value < h2.value) {
                return merge1(h1, h2);
            } else {
                return merge1(h2, h1);
            }
        }

        private Node merge1(Node h1, Node h2) {
            if (h1.left == null) {
                h1.left = h2;
            } else {
                h1.right = merge(h1.right, h2);
                if (h1.left.npl < h1.right.npl) {
                    Node temp = h1.left;
                    h1.left = h1.right;
                    h1.right = temp;
                }
                h1.npl = h1.right.npl + 1;
            }
            return h1;
        }

    }

}
