package org.github.数据结构与算法.tree;

/**
 * @author JiHongYuan
 * @date 2021/6/27 21:32
 */
public abstract class AbstractTree<T extends AbstractTree.Node<T>> {
    protected TreeUtil<T> treeUtil = new TreeUtil<>();

    protected T root;

    public AbstractTree(T root) {
        this.root = root;
    }

    public AbstractTree() {
    }

    public void builderTree(Integer... ints) {
        for (Integer integer : ints) {
            insert(integer);
        }
    }

    public static class Node<T> {
        public Integer value;
        public T left;
        public T right;

        public Node(Integer value) {
            this.value = value;
        }

        public Node(Integer value, T left, T right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public void printPreorder() {
        treeUtil.printPreorder(root);
    }

    public void printInorder() {
        treeUtil.printInorder(root);
    }

    public void printPostorder() {
        treeUtil.printPostorder(root);
    }


    public void printTree() {
        treeUtil.show(root);
    }

    static class TreeUtil<T extends AbstractTree.Node<T>> {
        /**
         * 先序打印
         * parent -> left -> right
         */
        private void printPreorder(Node<T> head) {
            if (head == null) return;
            System.out.print(head.value + ",");
            printPreorder(head.left);
            printPreorder(head.right);
        }

        /**
         * 中序打印
         * left -> parent -> right
         */
        private void printInorder(Node<T> head) {
            if (head == null) return;
            printInorder(head.left);
            System.out.print(head.value + ",");
            printInorder(head.right);
        }

        /**
         * 后序打印
         * left -> right -> parent
         */
        private void printPostorder(Node<T> head) {
            if (head == null) return;
            printPostorder(head.left);
            printPostorder(head.right);
            System.out.print(head.value + ",");
        }

        // *********************************************************************
        // 用于获得树的层数
        private int getTreeDepth(Node<T> root) {
            return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
        }

        private void writeArray(Node<T> currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
            // 保证输入的树不为空
            if (currNode == null) return;
            // 先将当前节点保存到二维数组中
            res[rowIndex][columnIndex] = String.valueOf(currNode.value);

            // 计算当前位于树的第几层
            int currLevel = ((rowIndex + 1) / 2);
            // 若到了最后一层，则返回
            if (currLevel == treeDepth) return;
            // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
            int gap = treeDepth - currLevel - 1;

            // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
            if (currNode.left != null) {
                res[rowIndex + 1][columnIndex - gap] = "/";
                writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
            }

            // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
            if (currNode.right != null) {
                res[rowIndex + 1][columnIndex + gap] = "\\";
                writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
            }
        }

        public void show(Node<T> root) {
            if (root == null) {
                System.out.println("EMPTY!");
                return;
            }
            // 得到树的深度
            int treeDepth = getTreeDepth(root);

            // 最后一行的宽度为2的（n - 1）次方乘3，再加1
            // 作为整个二维数组的宽度
            int arrayHeight = treeDepth * 2 - 1;
            int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
            // 用一个字符串数组来存储每个位置应显示的元素
            String[][] res = new String[arrayHeight][arrayWidth];
            // 对数组进行初始化，默认为一个空格
            for (int i = 0; i < arrayHeight; i++) {
                for (int j = 0; j < arrayWidth; j++) {
                    res[i][j] = " ";
                }
            }

            // 从根节点开始，递归处理整个树
            // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
            writeArray(root, 0, arrayWidth / 2, res, treeDepth);

            // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
            for (String[] line : res) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < line.length; i++) {
                    sb.append(line[i]);
                    if (line[i].length() > 1 && i <= line.length - 1) {
                        i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                    }
                }
                System.out.println(sb.toString());
            }
        }
    }

    public abstract void insert(int value);
}
