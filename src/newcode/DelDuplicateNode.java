package newcode;

/**
 * @program: offer
 * @description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author: co1de
 * @create: 2019-03-02 16:52
 **/

public class DelDuplicateNode {

//    class ListNode {
//        int val;
//        ListNode next = null;
//
//        ListNode(int val) {
//            this.val = val;
//        }
//    }

    /**
    * @Description:  1 1 1 2 3 4
    * @Param:偷懒思路，统计各个数字出现的次数，然后重新组织链表，次数大于1的不加入链表
    * @return:
    * @Author: co1de
    * @Date: 2019/3/2
    */
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead==null) return null;
        if (pHead.next==null) return pHead;
        ListNode preNode = null;
        ListNode currentNode = pHead;
        ListNode startNode = null;
        boolean continuee = false;
        int tempvalue ;
        while (currentNode!=null){
            //标记是否遇到连续数字
            if (currentNode.next!=null&&currentNode.val==currentNode.next.val){
                continuee = true;
            }
            //遇到连续数字进行删除
            if (continuee){
                tempvalue = currentNode.val;
                ListNode temp = currentNode;
                while (currentNode!=null && currentNode.val==tempvalue){
                    temp = currentNode.next;
                    //currentNode.next=null;
                    currentNode = temp;
                    //防止开头就是连续数字，不是的话就记录下一个不重复的
                    if (preNode!=null) {
                        preNode.next = temp;
                    }
                }
                continuee=false;
            }else {
                //记录起始位置用来返回，第一次记录就可以了
                if (startNode==null){
                    startNode=currentNode;
                }
                //prenode用来进行删除节点后的连接
                preNode=currentNode;
                currentNode = currentNode.next;
            }

        }
        return startNode;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(1);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        ListNode ret = new DelDuplicateNode().deleteDuplication(n1);
        while (ret.next!=null){
            System.out.print(ret.val+"->");
            ret=ret.next;
        }
        System.out.println(ret.val);

    }
}
