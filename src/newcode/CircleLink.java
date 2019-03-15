package newcode;

import java.util.ArrayList;

/**
 * @program: offer
 * @description: 一个链表中包含环，请找出该链表的环的入口结点。要求不能使用额外的空间。
 * @author: co1de
 * @create: 2019-03-15 20:02
 **/

public class CircleLink {
    /** 
    * @Description: 思路很简单，找一个容器开始放入，如果容器中已有则说明进入了循环，返回当前节点，就是入口
     * 发现hashset更好，会插入不成功会返回false
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/3/15 
    */ 
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead==null) return null;
        ArrayList<ListNode> temp = new ArrayList<>();
        //若有环则在内退出，否则直接返回null
        while (pHead!=null){
            if (!temp.contains(pHead)){
                temp.add(pHead);
                pHead=pHead.next;
                continue;
            }else {
                return pHead;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CircleLink cl = new CircleLink();
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
        System.out.println(cl.EntryNodeOfLoop(n1));
    }
}
