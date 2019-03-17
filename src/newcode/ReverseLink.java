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
        n5.next=n3;
        System.out.println(rl.ReverseList(n1));
    }
}
