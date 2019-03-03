package newcode;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * */
public class NumberOnes {
    public static void main(String[] args) {
        System.out.println(NumberOf1(-10));
    }
    //普通思路
    public static int NumberOf1(int n) {
        String num = Integer.toBinaryString(n);
//        System.out.println(num);
        int count = 0;
        for (int i=0;i<num.length();i++){
            if (num.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }


//    int sum=0;
//        while(n!=0){
//        sum+=n&1;//逐个判断低位是否为1；
//        n=n>>>1;//无符号右移，例如从11101变成1110
//    }

}
