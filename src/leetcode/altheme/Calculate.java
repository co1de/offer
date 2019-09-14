package leetcode.altheme;

import java.util.Stack;

public class Calculate {
    public int calculate(String s) {
        Stack<Integer> data = new Stack<>();
        Stack<Character> opt = new Stack<>();
        int temp=0;
        opt.push('+');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9' ) {
                //处理多位数
                temp = temp * 10 + (s.charAt(i) - '0');
            }
            if (s.charAt(i)<'0' && s.charAt(i) != ' ' || i==s.length()-1) {
                int ret = temp;
                switch (opt.pop()) {
                    case '*':
                        ret = data.pop() * (temp);
                        break;
                    case '/':
                        ret = data.pop() / (temp);
                        break;
                    case '-':
                        ret = -(temp);
                        break;
                    case '+':
                        ret = (temp);
                        break;
                }
                data.push(ret);
                opt.push(s.charAt(i));
                temp=0;
            }
        }
        int result = 0;
        while (!data.empty()) {
            result += data.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Calculate().calculate("3+2*2"));
    }
}
