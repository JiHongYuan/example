package org.github.数据结构与算法.hash;

/**
 * @author JiHongYuan
 * @date 2021/6/18 16:00
 * <p>
 * 分离链式法
 */
public class HashTable {
    int size;
    linkedList[] nodes;

    public HashTable(int size) {
        this.size = size;
        nodes = new linkedList[size];
    }

    public void put(Integer key, Integer value) {
        int mod = key % size;
        linkedList node = nodes[mod];
        if (node == null) {
            linkedList linkedList = new linkedList();
            linkedList.value = new Node(key, value);
            nodes[mod] = linkedList;
        } else {
            linkedList dummy = new linkedList();
            dummy.next = node;
            dummy.value = new Node(-1, -1);
            linkedList temp = dummy;
            while (temp.next != null) {
                if (temp.value.key.equals(key)) {
                    temp.value.value = value;
                    return;
                }
                temp = temp.next;
            }

            final linkedList linkedList = new linkedList();
            linkedList.value = new Node(key, value);
            temp.next = linkedList;
        }
    }

    public int get(Integer key) {
        int mod = key % size;
        linkedList temp = nodes[mod];
        while (temp != null) {
            if (temp.value.key.equals(key)) {
                return temp.value.value;
            }
            temp = temp.next;
        }
        return -1;
    }

    static class linkedList {
        public Node value;
        public linkedList next;
    }

    static class Node {
        public Integer key;
        public Integer value;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.put(1, 1);
        hashTable.put(11, 2);
        hashTable.put(111, 3);
        hashTable.put(1111, 4);

        System.out.println(hashTable.get(1));
        System.out.println(hashTable.get(11));
        System.out.println(hashTable.get(111));
        System.out.println(hashTable.get(1111));
    }


}
