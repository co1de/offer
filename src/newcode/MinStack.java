package newcode;

import java.util.Stack;

/**
 * @program: offer
 * @description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @author: co1de
 * @create: 2019-03-22 21:00
 **/

public class MinStack {
    /**temp用来存放最小元素列表*/
    private Stack<Integer> temp = new Stack<>();
    /**data用来存放实际栈数据*/
    private Stack<Integer> data = new Stack<>();
    
    /** 
    * @Description: 当初始化时，直接将第一个元素放入最小栈 
     * 如果当前入栈的节点比最小栈头还小，则压入最小栈，
     * 实际数据栈正常压入数据即可
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/3/22 
    */ 
    public void push(int node) {
        if (temp.size()==0){temp.push(node);}
        if (node<temp.peek()){
            temp.push(node);
        }
        data.push(node);
    }

    /** 
    * @Description: 如果实际弹出的数据是最小数据，需要将最小栈数据也弹出，否则只弹出数据栈即可 
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/3/22 
    */ 
    public void pop() {
        if (data.peek().equals(temp.peek())){
            data.pop();
            temp.pop();
        }else  data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return temp.peek();
    }
}
