package newcode;

/**
 * @program: offer
 * @description: 数值的整数次方，给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author: co1de
 * @create: 2019-02-26 21:07
 **/

public class MathSquare {
    public double Power(double base, int exponent) {
//        利用分数的思路处理，比函数库略快一点。。
        String d = String.valueOf(base);
        String[] s = d.split("\\.");
        double d1 = Double.valueOf(s[0]);
        int count = 0;
        for (char c:s[1].toCharArray()) {
            count++;
        }
        double d2 = Double.valueOf(s[1]);
        double up = Math.pow(10,count+1)*d1+d2;
        return Math.pow(up,exponent)/Math.pow(Math.pow(10,count+1),exponent);
    }
    /**
    * @Description:
     * 思路：若知道当前指数的一半，再乘一次就知道结果了。
     * 例如，要求 a^n，如果知道了 a^(n/2) 次方的话，再来个平方就可以了。
     * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/2/26
    */
    public double Power2(double base, int exponent) {
        if (exponent==0) return 1;
        if (exponent==1) return base;
        //若指数是负数
        if(exponent<0) {
            base = 1 / base;
            exponent = -exponent;
        }
        //算出了a^(n/2)
        double ans = Power2(base,exponent/2);
        //算出了a^n
        ans = ans*ans;
        //若指数是奇数，会少乘一次，这里补上
        if (exponent%2==1){
            ans = ans*base;
        }
        return ans;
    }

    /** 
    * @Description:
     * 用快速幂的思路，快速乘，减少乘的次数
     *将指数分解为二进制的形式，
     * 比如 a^156=a^10011100=a^(2^7*1+2^6*0+2^5∗0+2^4∗1+2^3∗1+2^2∗1+2^1∗0+2^0∗0=a^(2^7)*a^(2^4)*a^(2^3)*a^(2^2)*a^(2^1)
     * 注意：a^{2^7}=a^{2^6} * a^{2^6} ，而不是 a^{2^7}=a^{2^6} * a
     * 我们发现，若二进制为1，则它就等于它的前一位的平方，为0的话计算一下当前位，以备下次为1的时候计算
     *
     *
    * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/2/27
    */ 
    public double Power3(double base, int exponent) {
        if (exponent==0) return 1;
        if (exponent==1) return base;
        //若指数是负数,转为正数处理
        if(exponent<0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double ans = 1;
        while (exponent !=0){
            //位运算，如果末位是1
            if ((exponent&1) == 1){
                ans = ans *base;
            }
            //否则就计算当前位置
            base = base * base;
            //指数右移一位
            exponent = exponent >>> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        MathSquare ms = new MathSquare();
        System.out.println(ms.Power(2,-3));
        System.out.println(ms.Power2(2,-3));
    }
}
