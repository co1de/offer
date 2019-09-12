package newcode;

/**
 * @program: offer
 * @description: 输入一个链表，反转链表后，输出新链表的表头。
 * @author: co1de
 * @create: 2019-03-16 20:07
 **/

public class ReverseLink {
    /**
    * @Description: 思路很简单，用三个指针，第一个向前走，第二个记录当前，第三个记录前一个
     * 每次首先记录当前节点，然后移动快指针向前，将当前节点指向前一个节点，再用慢指针记录当前节点作为下一个循环的前节点。
    * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/3/16
    */
    public ListNode ReverseList(ListNode head) {
        if (head==null) return null;

         ListNode slow = null;
         ListNode fast = head;
        ListNode temp = null;
         while (fast!=null){
             //记录当前
             temp=fast;
             //指针移动
             fast=fast.next;
             //将当前节点指向前一个节点
            temp.next=slow;
            //记录当前节点，成为下一轮循环的上个节点
            slow=temp;
            if (fast==null) return temp;
         }
        return fast;
    }

    public ListNode myReverseList(ListNode head) {
        ListNode reListHead = null;
        ListNode cur = head;
        while (cur != null) {
            //先记录原链的下一个节点，防止断链
            ListNode next = cur.next;
            //将当前节点的下一个节点指向倒序节点的头
            cur.next = reListHead;
            //倒序链增长了1，移动到当前位置
            reListHead = cur;
            //将当前位置挪动到原链的下一个节点上
            cur = next;
        }
        return reListHead;
    }
    public ListNode ReverseListHeadInsert(ListNode head) {
        ListNode reListHead = new ListNode(-1);
        ListNode temp = head;
        while (head!=null) {
            temp = head.next;
            head.next = reListHead.next;
            reListHead.next = head;
            head = temp;
        }
        return reListHead.next;
    }

    public ListNode myPartReverse(ListNode head, int start, int end) {
        ListNode preNode = null;
        ListNode endNode = null;
        ListNode cur = head;
        int pos = 1;
        //找到首尾开始位置
        while (cur != null) {
            if (pos==start-1) preNode = cur;
            if (pos==end+1) endNode = cur;
            cur = cur.next;
            pos++;
        }

//        ListNode reNode = preNode.next;
//        cur = reNode.next;
        //连接到尾部
//        reNode.next = endNode;

        //开始交换部分位置,这一部和第三步相当于把原来的null头换为了当前头
        ListNode reNode = endNode;
        cur = preNode.next;

        while (cur != endNode) {
            ListNode next = cur.next;
            cur.next = reNode;
            reNode = cur;
            cur = next;
        }

        //连接前后
        preNode.next = reNode;
        return head;

    }

    public static void main(String[] args) {
        ReverseLink rl = new ReverseLink();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
//        n5.next=n3;
//        System.out.println(rl.ReverseList(n1));
        rl.myPartReverse(n1, 2, 4);
//        rl.reverseSublist(n1,2,4);
        while (n1 != null) {
            System.out.println(n1.val);
            n1=n1.next;
        }
    }
}
