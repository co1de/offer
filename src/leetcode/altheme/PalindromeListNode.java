package leetcode.altheme;

import java.util.Stack;

public class PalindromeListNode {
    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public boolean isPalindrome(ListNode head) {
        if (head==null) return false;
        Stack<Integer> stack = new Stack<>();
        stack.push(head.val);
        while (head.next != null) {
            head=head.next;
            if (head.val == stack.peek().intValue()) {
                stack.pop();
            } else {
                stack.push(head.val);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        System.out.println(new PalindromeListNode().isPalindrome(node));
    }
}
