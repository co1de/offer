package newcode;

import java.util.Stack;

/**
 * @program: offer
 * @description: 输入两个链表，找出它们的第一个公共结点。
 * @author: co1de
 * @create: 2019-06-14 19:49
 **/

public class FirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //有公共节点后链表后续都相同了，想要倒序查找
        //利用栈结构，完成倒序
        //思路二：因为相同节点后续一样，只需从短链表开始遍历比较两个节点即可。
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null) {
            s1.push(p1);
            p1=p1.next;
        }
        while (p2 != null) {
            s2.push(p2);
            p2=p2.next;
        }
        ListNode preNode = null;
        while (!s1.empty() && !s2.empty() && s1.peek().val == s2.peek().val) {
            preNode = s1.pop();
            s2.pop();
        }
        return preNode;
    }
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        //思路二：因为相同节点后续一样，只需从短链表开始遍历比较两个节点即可。
        ListNode p1 = pHead1;
        int pl1=0;
        ListNode p2 = pHead2;
        int pl2=0;
        while (p1 != null) {
            pl1++;
            p1=p1.next;
        }
        while (p2 != null) {
            pl2++;
            p2=p2.next;
        }
        int dis = pl1>=pl2?pl1-pl2:pl2-pl1;
        ListNode longNode = pl1 >= pl2 ? pHead1 : pHead2;
        ListNode shortNode = pl1 >= pl2 ? pHead2 : pHead1;
        //长的先走几步
        for (int i = 0; i < dis; i++) {
            longNode=longNode.next;
        }
        //开始起头并进找相同节点。
        while (longNode != null && shortNode != null && longNode.val != shortNode.val) {
            longNode=longNode.next;
            shortNode=shortNode.next;
        }
        return longNode;
    }
}
