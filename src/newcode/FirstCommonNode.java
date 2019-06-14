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
}
