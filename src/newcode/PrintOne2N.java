package newcode;

/**
 * @program: offer
 * @description: 剑指offer17题
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 * @author: co1de
 * @create: 2019-02-27 21:17
 **/

public class PrintOne2N {
    /** 
    * @Description: 考虑到数字可能很大，利用字符串模拟数字运算 
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/2/28 
    */ 
    public void pringNumber(int length){
//        必须有长度
        if (length<=0) return;
        char[] number = new char[length];
        for (int i=0;i<number.length;i++){
            number[i] = '0';
        }
        for (int n=increase(number);n<=number.length;n=increase(number)){
//            printN(number,n);
            System.out.println(new String(number).substring(number.length-n));
        }
    }

    private int increase(char[] number) {
        int actLength = 0;
        boolean go = false;
        int i =0;
        for (i=number.length-1;i>=0;i--){
            if (number[i]!='9'){
                number[i]++;
                go = false;
                break;
            }else {
                //是9，需要进位,当前位置0
                go = true;
                number[i] = '0';
            }
        }

        //算出实际位数
        for (int j=0;j<number.length;j++){
            if (number[j]!='0'){
                actLength = number.length-1-j+1;
                break;
            }
        }
        //如果累加循环出来了进位标志还为true，说明在最高位还要进位，即超出界限了。
        if (go) return number.length+1;

        return actLength;
    }

// 打印，只打印有效位数，即前面是0不打印出来
//    private void printN(char[] number, int n) {
//        System.out.println(new String(number).substring(number.length-n));
//    }

    public static void main(String[] args) {
        PrintOne2N p = new PrintOne2N();
        p.pringNumber(3);
    }
}
