package leetcode.altheme;

public class CopyRandomList {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        Node root = new Node();
        while (head != null) {

        }
        return root;
    }
}
