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
     * 还有一种思路，获得长度，在遍历的时候每个位置+1，当有个位置值为2时，就是入口了。
     *
     * * @Param:
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

    /**
    * @Description: 再来一个思路：使用双指针，一个指针 fast 每次移动两个节点，一个指针 slow 每次移动一个节点。因为存在环，所以两个指针必定相遇在环中的某个节点上。假设相遇点在下图的 z1 位置，此时 fast 移动的节点数为 x+2y+z，slow 为 x+y，由于 fast 速度比 slow 快一倍，因此 x+2y+z=2(x+y)，得到 x=z。
    在相遇点，slow 要到环的入口点还需要移动 z 个节点，如果让 fast 重新从头开始移动，并且速度变为每次移动一个节点，那么它到环入口点还需要移动 x 个节点。在上面已经推导出 x=z，因此 fast 和 slow 将在环入口点相遇。
     * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/3/15
    */
//    public ListNode EntryNodeOfLoop(ListNode pHead) {
//        if (pHead == null || pHead.next == null)
//            return null;
//        ListNode slow = pHead, fast = pHead;
//        do {
//            fast = fast.next.next;
//            slow = slow.next;
//        } while (slow != fast);
//        fast = pHead;
//        while (slow != fast) {
//            slow = slow.next;
//            fast = fast.next;
//        }
//        return slow;
//    }

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
