package leetcode.altheme;

public class OddEvenList {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode oddEvenList(ListNode head) {
        if (head==null) return null;
        ListNode odd = null;
        ListNode even = null;
        ListNode oddHead = null;
        ListNode evenHead = null;
        int curPos = 1;
        while (head != null) {
            if ((curPos & 1) == 0) {
                //even
                if (even == null) {
                    even = head;
                    evenHead = even;
                } else {
                    even.next=head;
                    even=even.next;

                }
            } else {
                //odd
                if (odd == null) {
                    odd = head;
                    oddHead = odd;
                } else {
                    odd.next=head;
                    odd=odd.next;
                }
            }
            head=head.next;
            if (even != null ) {
                even.next=null;
            }
            if (odd != null ) {
                 odd.next=null;
            }

            curPos++;
        }
        odd.next=evenHead;
        return oddHead;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode ret = new OddEvenList().oddEvenList(node);
        while (ret != null) {
            System.out.println(ret.val);
            ret = ret.next;
        }
    }

}
