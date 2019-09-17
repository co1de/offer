package leetcode.altheme;

import java.util.HashMap;

public class RingList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle2(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (head != null) {
            if (map.get(head) == null) {
                map.put(head, head.val);
            } else {
                return true;
            }
            head=head.next;
        }
        return false;
    }
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && slow!=null) {
            if (fast.next != null) {
                fast=fast.next.next;
                slow=slow.next;
                if (fast == slow) {
                    return true;
                }
            }else break;
        }
        return false;
    }
}
