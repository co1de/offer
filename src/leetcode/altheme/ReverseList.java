package leetcode.altheme;

public class ReverseList {
    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList2(ListNode head) {
        if (head==null) return null;
        ListNode root = new ListNode(-1);
        ListNode temp = null;
        while (head != null) {
            temp = head.next;
            head.next=root.next;
            root.next=head;
            head=temp;
        }
        return root.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }
}
