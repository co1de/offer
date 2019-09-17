package leetcode.altheme;

public class SortList {
    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }

    private void quickSort(ListNode start, ListNode end) {
        if (start != end) {
            ListNode k = partation(start, end);
            quickSort(start, k);
            quickSort(k.next, end);
        }
    }

    private ListNode partation(ListNode start, ListNode end) {
        ListNode low = start;
        ListNode pointer = start.next;
        while (pointer != null) {
            if (pointer.val < start.val) {
                low=low.next;
                int temp = pointer.val;
                pointer.val = low.val;
                low.val = temp;
            }
            pointer=pointer.next;
        }
        int temp = low.val;
        low.val = start.val;
        start.val=temp;
        return low;
    }

}
