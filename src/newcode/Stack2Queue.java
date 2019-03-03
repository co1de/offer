package newcode;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * */
public class Stack2Queue {
    //用来入队
    Stack<Integer> stack1 = new Stack<Integer>();
    //用来出队
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //2不为空，说明弹出过，先全部倒入恢复顺序，再继续入栈
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        //1不为空，说明有数据，将其倒入2后顺序自然反过来，然后可以弹栈
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

}
