package newcode;

/**
 * @program: offer
 * @description: 给定一个数组A[0, 1, ..., n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * @author: co1de
 * @create: 2019-06-17 16:12
 **/

public class BuildMultiplyArray {
    /** 
    * @Description: 作者：Blankeer
     * 链接：https://www.nowcoder.com/questionTerminal/94a4d381a68b47b7a8bed86f2975db46
     * 来源：牛客网
     *
     * B[i]的意义是A数组不包括i位置的所有乘积，分为 i左边的元素乘积和 i右边的所有元素乘积。第一个for计算i左边的乘积，第二个for计算右边的。初始化B[0]=1，是因为0左边没有元素，所以乘积为1。
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/6/17 
    */ 
    public int[] multiply(int[] A) {
        int[] b = new int[A.length];
        //根据题意看出可以先算左边的，放入b
        for (int i = 0,temp=1; i < b.length; i++) {
            b[i] = temp;
            temp *= A[i];
        }
        //然后再算右边的，取b中数据累乘
        for (int i = b.length-1, temp = 1; i >=0; i--) {
            b[i] *=temp;
            temp *= A[i];
        }
        return b;
    }
}
