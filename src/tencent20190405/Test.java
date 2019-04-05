package tencent20190405;

import java.util.Scanner;
import java.util.Stack;

/**
 * @program: offer
 * @description: 测试输入输出流
 * @author: co1de
 * @create: 2019-04-04 09:47
 **/

public class Test {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        String s = sc.nextLine();
        String s = "1100";
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            //第一个直接压入
            if (i==0) stack.push(s.charAt(i));
            if (s.charAt(i)=='0' && stack.size()>0 && stack.peek().equals('1') ){
                stack.pop();
                continue;
            }
            else if (s.charAt(i)=='1' && stack.size()>0 && stack.peek().equals('0') ){
                stack.pop();
                continue;
            }else {
                if (i>0){
                    stack.push(s.charAt(i));
                }
            }
        }

        System.out.println(stack.size());
    }
}
