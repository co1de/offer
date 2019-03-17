package newcode;

/**
 * @program: offer
 * @description: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author: co1de
 * @create: 2019-03-17 21:59
 **/

public class MergeLinkList {
    /** 
    * @Description: 用两个指指向两个链表头，比较大小，依次填入新链表，注意要额外的一个ret记录新链表头 
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/3/17 
    */ 
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null) return list2;
        if (list2==null) return list1;
        ListNode ret=null,newOne = null;
        while (list1!=null && list2!=null){
            if (list1.val<=list2.val){
               if (newOne==null) ret=newOne=list1;
               else {
                   newOne.next=list1;
                   newOne=newOne.next;
               }
               list1=list1.next;
            }else {
                if (newOne==null) ret=newOne=list2;
                else {
                    newOne.next=list2;
                    newOne=newOne.next;
                }
                list2=list2.next;
            }
        }
        //如果一个链表较长，直接追到后面即可
        if(list1!=null){
            newOne.next=list1;
        }
        if(list2!=null){
            newOne.next=list2;
        }
        return ret;
    }

    public static void main(String[] args) {
        MergeLinkList ml = new MergeLinkList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(6);
        n1.next=n2;
        n2.next=n3;
        n3.next=null;
        n4.next=n5;
        n5.next=n6;
        n6.next=null;
//        System.out.println(n1.val);
        ListNode n=ml.Merge(n1,n4);
        while (n !=null){
            System.out.println(n.val);
            n=n.next;
        }
//        System.out.println();
    }
}
