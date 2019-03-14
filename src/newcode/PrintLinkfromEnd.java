package newcode;

/**
 * @program: offer
 * @description: 输入一个链表，输出该链表中倒数第k个结点。
 * @author: co1de
 * @create: 2019-03-14 20:54
 **/

public class PrintLinkfromEnd {
//    class ListNode {
//        int val;
//        ListNode next = null;
//
//        ListNode(int val) {
//            this.val = val;
//        }
//    }
    /** 
    * @Description: 两个指针，第一个指针移动，第二个指针从第一个指针的位置向后探测k-1步，因为倒数第k个还能往前走k-1步
     * 若探测到末尾，就找到了倒数第k个位置，返回p1即可
     *
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/3/14 
    */ 
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null || k==0) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        int step=0;
        //修改p1.next！=null如下，不用判断最后，链表都可以这样来用最后节点判断，用next判断可能掉尾节点。
        while (p1!=null){
            step=0;
            while (step<k-1){
                if (p2.next!=null){
                    p2=p2.next;
                }else break;
                step++;
            }
            if (step==k-1 && p2.next==null){
                return p1;
            }
            p1=p1.next;
            p2=p1;

        }
        //防止最后一个漏掉
//        if(k==1) return p1;
        return null;
    }

    public static void main(String[] args) {
        PrintLinkfromEnd p = new PrintLinkfromEnd();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=null;
        System.out.println(p.FindKthToTail(n1,1).val);
    }
}
