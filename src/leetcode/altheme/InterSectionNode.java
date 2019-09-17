package leetcode.altheme;

import java.util.ArrayList;

public class InterSectionNode {
    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ArrayList<ListNode> listA = new ArrayList<>();
        ArrayList<ListNode> listB = new ArrayList<>();
        while (headA != null) {
            listA.add(headA);
            headA= headA.next;
        }
        while (headB != null) {
            listB.add(headB);
            headB= headB.next;
        }
        int aPos = listA.size()-1;
        int bPos = listB.size()-1;
        ListNode ret = null;
        while (aPos >= 0 && bPos >= 0) {
            if (listA.get(aPos)==(listB.get(bPos))) {
                ret = listA.get(aPos);
                aPos--;
                bPos--;
            } else {
                break;
            }
        }
        return ret;
    }
}
