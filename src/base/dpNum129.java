package base;

/**
 * @program: offer
 * @description: record backpack question 1 to 9
 * @author: co1de
 * @create: 2019-06-05 21:18
 **/

public class dpNum129 {
    /**
    * @Description:  基础的01背包问题，物品仅有一件，可以选择放或不放。前i个物品在容量为j时的最大容量
     * f[i][j]= f[i-1][j],weigh[i]>j
     *        = Math.max(f[i-1][j],f[i-1][j-weigh[i]]+value[i]),weigh[i]<j
     *
    * @param number  物品数量，应和数组长度相等
     * @param capacity  背包总容量
     * @param weigh 每个物品重量
     * @param value 每个物品价值
    * @return:
    * @Author: co1de
    * @Date: 2019/6/5
    */
    public static void zeroOnePackV1(int number,int capacity,int[] weigh,int[] value){
        //多一行列是为了表示不放物品（第0个物品）和没有容量（第0个容量）
        int[][] f = new int[number+1][capacity+1];
        //先初始化表行列为0,java默认全0,可以省略。
        //初始化第一列为0，意义是包裹重量为0时，所有物品都放不进去，因此都是0
        for (int i = 0; i <= number; i++) {
             f[i][0] = 0;

        }
        //初始化第一行为0，意义第0个物品（即不放物品）时，包裹多大都没有价值。
        for (int j = 0; j <= capacity; j++) {
                f[0][j] = 0;
        }
        //开始根据状态转移方程填表
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= capacity; j++) {
                //第i件物品重量大于当前总重量，装不下的i个，因此取i-1的情况
                //注意weigh和value下标是比i和j小1的，因为二者是从0开始。
                if (j<weigh[i-1]){
                    f[i][j] = f[i - 1][j];
                }else {
                    //此时才判断需不需要拿。
                    //note:为了理解一维优化，这里多说一句，
                    //这里其实是在取表中当前位置的上一个和上一个的前一个这两个位置
                    //如果空间优化代码只是简单的降维，前面修改的值可能会影响到后面的值。
                    f[i][j] = Math.max(f[i-1][j],f[i-1][j-weigh[i-1]]+value[i-1]);
                }
            }
        }
        System.out.println(f[number][capacity]);
    }

    /** 
    * @Description: 01问题的空间优化版，
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/6/5 
    */ 
    public static void zeroOnePackV2(int number,int capacity,int[] weigh,int[] value){
        int[] f = new int[capacity+1];
        //若不要求背包装满，初始化全为0即可,因为此时的合法状态是可以不装东西，该位置价值为0
        for (int i = 0; i < f.length; i++) {
            f[i] = 0;
        }

        //若要求背包装满，f[0]为0，其余为-∞.此时的合法状态是，包为0时装满只能什么也不装价值为0.其他情况均未确定所以为负无穷。
//        for (int i = 1; i < f.length; i++) {
//            f[i]=Integer.MIN_VALUE;
//        }

        //开始填表与更新
        for (int i = 1; i <= number; i++) {
            //其实这里的下界还能调整，即将if判断条件移入for即可。
            for (int j = capacity; j >= 1; j--) {
                if (j>weigh[i-1]){
                    //能拿就从上一行两个位置中判断
                    f[j] = Math.max(f[j],f[j-weigh[i-1]]+value[i-1]);
                }else {
                    //不能拿就继承上一行
                    f[j] = f[j];
                }
            }
        }
        System.out.println(f[capacity]);
    }

    public static void main(String[] args) {
        int[] weight = {3,5,2,6,4}; //物品重量
        int[] val = {4,4,3,5,3}; //物品价值
        int m = 12; //背包容量
        int n = val.length; //物品个数
        zeroOnePackV1(n,m,weight,val);
        zeroOnePackV2(n,m,weight,val);
    }
}
