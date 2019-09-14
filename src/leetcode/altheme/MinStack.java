package leetcode.altheme;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        data.push(x);
        if (!min.empty()) {
            if (min.peek() >= x) {
                min.push(x);
            }
        } else {
            min.push(x);
        }
    }

    public void pop() {
        int popData = 0;
        if (!data.empty()) {
             popData = data.pop();
        }
        if (popData == min.peek()) {
            min.pop();

        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
