package newcode;

import java.util.ArrayList;
import java.util.Collections;

public class PrintList {

     class ListNode {
     int val;
     ListNode next = null;
     ListNode(int val) {
         this.val = val;
        }
    }
    public static void main(String[] args) {
//        ArrayList<Integer>
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> returnArrayList = new ArrayList<>();
        if (listNode!=null){
            while (listNode.next!=null){
                arrayList.add(listNode.val);
                //头插法更简单
//                arrayList.add(0,listNode.val);
                listNode = listNode.next;
            }
            //最后一个值
            arrayList.add(listNode.val);
            int pos = arrayList.size()-1;
            while (!arrayList.isEmpty()){
                returnArrayList.add(arrayList.remove(pos--));
            }
        }
        return returnArrayList;
    }
}
