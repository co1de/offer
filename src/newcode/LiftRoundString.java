package newcode;

/**
 * @program: offer
 * @description: 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * @author: co1de
 * @create: 2019-06-16 20:30
 **/

public class LiftRoundString {
    /**
    * @Description: 分析可知，本题是将前n个数据与str.length-n个数据组成的两个字符串交换位置。
    * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/6/16
    */
    public String LeftRotateString(String str,int n) {
        String ret = "";
        if (str!=null && str.length()>0){
            String left = str.substring(0, n);
            String right = str.substring(n, str.length());
            ret=right+left;
        }
        return ret;
    }

    /** 
    * @Description: 另一个思路，借助翻转字符串方法，进行三次翻转 
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/6/16 
    */ 
    public String LeftRotateString2(String str,int n) {
        String ret = "";
        if (str!=null && str.length()>0){
            //翻转整个句子
            char[] t = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                t[i]=str.charAt(str.length()-1-i);
            }
            int low =0;
            int high = 0;
            while (high < str.length()) {
                //翻转前str.length-n个字
                if ( high==str.length()-1-n){
                    int i=low, j=high;
                    while (i <= j) {
                        exchange(t, i++, j--);
                    }
                    low=high+1;
                }else if (low==str.length()-n){
                    int i=low, j=str.length()-1;
                    while (i <= j) {
                        exchange(t, i++, j--);
                    }
                    break;
                }
                high++;
            }
            ret = new String(t);
        }
        return ret;
    }

    private void exchange(char[] t, int i, int j) {
        char tmp = t[i];
        t[i] = t[j];
        t[j] = tmp;
    }

    public static void main(String[] args) {
        String s = "abcXYZdef";
        System.out.println(new LiftRoundString().LeftRotateString2(s,3));
    }
}
