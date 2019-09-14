package leetcode.altheme;

import java.util.Stack;

public class EvalRPN {
    private Stack<Integer> data = new Stack<>();
    private Stack<String> opt = new Stack<>();
    public int evalRPN(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
                data.push(Integer.valueOf(tokens[i]));
                continue;
            }
            int temp = 0;
            switch (tokens[i]) {
                case "+": temp=data.pop()+data.pop();break;
                case "-": temp=-data.pop()+data.pop();break;
                case "*": temp=data.pop()*data.pop();break;
                case "/":
                    int num1 = data.pop();
                    temp=data.pop()/num1;
                    //temp = 1/data.pop()*data.pop();
                    break;
            }
            data.push(temp);
        }
        return data.pop();
    }

    public static void main(String[] args) {
        String[] s = {"2","1","+","3","*"};
        System.out.println(new EvalRPN().evalRPN(s));
    }
}
