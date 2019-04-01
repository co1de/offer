package newcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: offer
 * @description: 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空，
 * ps这里是指不能含有原链表的节点，否则会判为null）
 * @author: co1de
 * @create: 2019-03-29 21:33
 **/

public class CopyComplicatedLinkList {

    /** 
    * @Description: 剑指offer上的思路，利用额外的链表节点，然后断链 
    * @Param:  
    * @return:
    * @Author: co1de
    * @Date: 2019/4/1 
    */ 
    public RandomListNode Clone2(RandomListNode pHead){
        //不能反回链表中的任何节点。。空也得重新返回
        if(pHead==null) return null;

        RandomListNode cur = pHead;
        RandomListNode newNode = null;
        //对每个节点做一次复制
        while (cur != null) {
            newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next = newNode;
            cur=newNode.next;
        }

        //做random连接
        cur = pHead;
        while (cur != null) {
            if (cur.random!=null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //断链处理,对每个节点进行处理,主要是断next链
        cur = pHead;
        RandomListNode ret = cur.next;
        while (cur != null) {
            RandomListNode newOne = cur.next;
            if (newOne!=null){
                cur.next = newOne.next;
                cur=newOne;
            }else {
                //说明到达最后一个节点了
                break;
            }
        }

        return ret;
    }

    /**
    * @Description: 利用hashmap存储
    * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/4/1
    */
    public RandomListNode Clone1(RandomListNode pHead){
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        RandomListNode copy = new RandomListNode(-1);
        RandomListNode copyCur = copy;
        while (cur != null) {
            copyCur.next = new RandomListNode(cur.label);
            copyCur=copyCur.next;
            map.put(cur,copyCur);
            cur=cur.next;
        }
        cur = pHead;
        while (cur!=null){
            //因为链表都在map中，cur的random也在map中，且cur.random在map中对应的为copy的新节点，也起到了断链的作用。
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return copy.next;
    }
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

    public static void main(String []args) {
        CopyComplicatedLinkList solution = new CopyComplicatedLinkList();

        RandomListNode yiHead = new RandomListNode(1);
        RandomListNode erNode = new RandomListNode(2);
        RandomListNode sanNode = new RandomListNode(3);
        RandomListNode siNode = new RandomListNode(4);
        RandomListNode wuNode = new RandomListNode(5);

        yiHead.next = erNode;
        erNode.next = sanNode;
        sanNode.next = siNode;
        siNode.next = wuNode;

        yiHead.random = sanNode;
        erNode.random = wuNode;
        sanNode.random = null;
        siNode.random = erNode;
        wuNode.random = null;


        RandomListNode newNode = solution.Clone2(yiHead);

        RandomListNode temp1 = newNode;
        while (temp1 != null) {
            System.out.print(temp1.label + "    ");
            temp1 = temp1.next;
        }

        System.out.println();

        temp1 = newNode;
        while (temp1 != null) {
            if (temp1.random == null) {
                System.out.print("#" + "    ");
            } else {
                System.out.print(temp1.random.label + " ");
            }

            temp1 = temp1.next;
        }
    }

}
