package newcode;

/**
 * @program: offer
 * @description: 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @author: co1de
 * @create: 2019-03-29 21:33
 **/

public class CopyComplicatedLinkList {
    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode ret = new RandomListNode(-1);
        RandomListNode tmp = pHead;
        RandomListNode tmpret = ret;

        //完成主链的复制
        while (pHead != null) {
            ret.next = new RandomListNode(pHead.label);
            pHead=pHead.next;
            ret = ret.next;
        }
        //用临时变量作为指针
        RandomListNode tmpRet = ret.next;
        RandomListNode tmpRet2 = ret.next;
        while (tmp != null) {
            while (tmpRet != null) {
                if (tmp.random.label == tmpRet.label){
                    tmpRet2.random=tmpRet;
                    tmpRet2 = tmpRet2.next;
                }
                //临时指针继续检查
                tmpRet=tmpRet.next;
            }
            //临时指针回到头部
            tmpRet = tmpret.next;
            //检查指针移动到下一个节点
            tmp=tmp.next;
        }

        return tmpret.next;
    }
}
