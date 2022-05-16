package org.github.数据结构与算法.tree.binary;

import org.github.数据结构与算法.stack.InfixConvertSuffixCalc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

/**
 * @author JiHongYuan
 * @date 2021/6/18 14:34
 */
public class ExpressTree {
    public static void main(String[] args) {
        String expression = "4.99 * 1.06 + 5.99 + 6.99 * 1.06";
        List<String> stringList = InfixConvertSuffixCalc.infixTransformSuffix(expression);


        Stack<Node<String>> stack = new Stack<>();
        for (String str : stringList) {
            if (InfixConvertSuffixCalc.SymbolEnum.getSymbolEnumByString(str) != InfixConvertSuffixCalc.SymbolEnum.NONE) {
                Node<String> parent = new Node<>(str, stack.pop(), stack.pop());
                stack.push(parent);
            } else {
                stack.push(new Node<>(str, null, null));
            }
        }

        Node<String> root = stack.pop();
        printInorder(root);
        System.out.println();
        System.out.println(calc(root).toString());
    }

    public static <E> void printInorder(Node<E> head) {
        if (head == null) return;
        System.out.print("( ");
        printInorder(head.left);
        System.out.print(head.item + " ");
        printInorder(head.right);
        System.out.print(" ) ");
    }

    public static <E> E calc(Node<E> node) {
        if (node == null) return null;

        InfixConvertSuffixCalc.SymbolEnum symbol = InfixConvertSuffixCalc.SymbolEnum.getSymbolEnumByString(node.item.toString());

        if (symbol != InfixConvertSuffixCalc.SymbolEnum.NONE) {
            BigDecimal n1 = new BigDecimal(calc(node.left).toString());
            BigDecimal n2 = new BigDecimal(calc(node.right).toString());

            BigDecimal result;
            switch (symbol) {
                case ADD:
                    result = n1.add(n2);
                    break;
                case SUB:
                    result = n1.subtract(n2);
                    break;
                case MUL:
                    result = n1.multiply(n2);
                    break;
                case DIV:
                    result = n1.divide(n2);
                    break;
                default:
                    result = BigDecimal.ZERO;
            }
            node.item = (E) result.toString();
        }

        return node.item;
    }

    private static class Node<E> {
        E item;
        Node<E> left;
        Node<E> right;


        public Node(E item, Node<E> left, Node<E> right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

    }

}
