package base;

/**
 * @program: offer
 * @description: 二叉查找树的简单实现
 * @author: co1de
 * @create: 2019-05-30 20:30
 **/

public class BinarySearchTree<K extends Comparable<K>,V> {
    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left,right;
        //以该节点为根的子树中的节点总数
        private int N;

        public Node(K key, V value,  int n) {
            this.key = key;
            this.value = value;
            N = n;
        }

        public Node() {
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node root) {
        return root==null?0:root.N;
    }

    public V get(K key) {
        return get(root, key);
    }
    //其实就是二分查找，递归的实现
    private V get(Node root, K key) {
        if (key == null) {
            return null;
        }
        if (key.compareTo(root.key) < 0) {
            return get(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            return get(root.right, key);
        }else return root.value;
    }

    public void put(K key, V value) {
        root = put(root,key,value);
    }

    //还是二分思想，找到合适位置插入
    private Node put(Node root, K key, V value) {
        if (root==null) return new Node(key, value, 1);
        if (key.compareTo(root.key) < 0) {
            root.left = put(root.left, key, value);
        } else if (key.compareTo(root.key) > 0) {
            root.right = put(root.right, key, value);
        }else root.value = value;
        //更新n
        root.N = size(root.left)+size(root.right)+1;
        return root;
    }

    public K getMin() {
        return getMin(root).key;
    }

    private Node getMin(Node root) {
        if (root.left==null) return root;
        else return getMin(root.left);
    }

    public K floor(K key) {
        Node x = floor(root, key);
        if (x != null) {
            return x.key;
        }else return null;
    }

    //floor(key)：小于等于键的最大键,可用来判断地址段
    private Node floor(Node root, K key) {
        if (root == null) {
            return null;
        }
        if (root.key.compareTo(key)==0) return root;
        else if (key.compareTo(root.key) < 0) {
            return floor(root.left, key);
        }
        //关键在这一步,当key大于根时，要去判断右边是否还有小于等于key的键
        Node right = floor(root.right, key);
        if (right == null) return root;
        else return right;

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.put(10,10);
        bst.put(3, 3);
        bst.put(20, 20);
        bst.put(1, 1);
        bst.put(6,6);
        System.out.println(bst.floor(2));
    }
}
