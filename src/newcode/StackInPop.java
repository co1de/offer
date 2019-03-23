package newcode;

import java.util.Stack;

/**
 * @program: offer
 * @description: 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @author: co1de
 * @create: 2019-03-23 20:12
 **/

public class StackInPop {
    /**
     * @Description: 利用一个栈来临时存储，首先根据输入序列和弹出序列，进行压栈操作
     * 如果当前数字不是弹出的，先压入栈，继续扫描入栈数组
     * 如果当前数字应该压入栈，跳过该数字，同时移动出栈数组指针，继续判断下一个
     * 这样当扫描完入栈数组后，出栈数组中剩余的序列应该和栈中的序列相同，如果不相同则说明不能按照该序列弹出栈
     * 最后扫描一下栈和出栈数组序列看是否匹配即可。
     * @Param:
     * @return:
     * @Author: co1de
     * @Date: 2019/3/23
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA==null || popA==null) return false;
        Stack<Integer> temp = new Stack<>();
        int push=0,pop=0;
        for (;push<pushA.length;push++) {
            //当前不是弹出的数字，压入栈
            if (pushA[push] != popA[pop]) {
                temp.push(pushA[push]);
                continue;
            } else {
                //若是要弹出的数字，移动指针
                pop++;
                continue;
            }
        }
        //栈里剩余的应与弹出序列匹配，若不匹配说明不能完成该序列
        while(!temp.empty()){
            if (temp.pop().equals(popA[pop++])){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    /**
    * @Description:  这个更加直观，利用栈，压入一个数字后，直接根据弹出序列判断栈中的数字能否弹出，如果能就继续判断下一个能否弹出
    * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/3/23
    */
    public boolean IsPopOrder2(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            while (popIndex < n && !stack.isEmpty()
                    && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = { 4, 5,3, 2, 1,};
        int[] c = { 4, 3,5,1,2};
        System.out.println(new StackInPop().IsPopOrder(a,c));
    }
}
