package base;

/**
 * @program: offer
 * @description: record backpack question 1 to 9
 * @author: co1de
 * @create: 2019-06-05 21:18
 **/

public class dpNum129 {
    /**
    * @Description:
     * 有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]。
     * 求解将哪些物品装入背包可使价值总和最大。
     *
     *
     * 基础的01背包问题，物品仅有一件，可以选择放或不放。
     * 即f[i][v]表示前i件物品恰放入一个容量为v的背包可以获得的最大价值
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

        for(int i = 0; i <= number; i++) {
            for(int j = 0; j <= capacity; j++) {
                System.out.print(f[i][j] + " ");
            }
            System.out.println();
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
                if (j>=weigh[i-1]){
                    //能拿就从上一行两个位置中判断
                    f[j] = Math.max(f[j],f[j-weigh[i-1]]+value[i-1]);
                }else {
                    //不能拿就继承上一行
                    f[j] = f[j];
                }
            }
        }
        for(int j = 0; j <= capacity; j++) {
            System.out.print(f[j] + " ");
        }
        System.out.println();
        System.out.println(f[capacity]);
    }

    /**
    * @Description:
     * 有N种物品和一个容量为V的背包，每种物品都有无限件可用。
     * 第i种物品的费用是c[i]，价值是w[i]。
     * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
     *
     * 思路：考虑到物品是可以取0，1，2，……件的，套用01背包的方式，我们可以得到如下递推式
     * f[i][j]=max{f[i-1][j-k*weigh[i]]+k*value[i],0<=k*weigh[i]<=j}
     * @param number 物品种数
    * @param capacity 背包容量
     * @param weigh 物品重量
     * @param value 物品价值
    * @return:  
    * @Author: co1de
    * @Date: 2019/6/18 
    */ 
    public static void fullPackV1(int number,int capacity,int[] weigh,int[] value) {
        int[][] dp = new int[number + 1][capacity + 1];
        //初始化,不要求装满的话全0即可，默认全0，可省略
        //开始套用公式填表
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= capacity; j++) {
                //能取0，1，……一直到capacity/weigh[i]件,注意weigh坐标小一个的问题
                for (int k = 0; k <= capacity / weigh[i-1]; k++) {
                    //能装下
                    if (j >= k * weigh[i-1]) {
                        dp[i][j] = Math.max(dp[i - 1][j - k * weigh[i-1]] + k * value[i-1], dp[i][j]);
                    } else {
                        //装不下
                        //这里不取dp[i][j]=dp[i-1][j]
                        //观察上面的取max值，即在能装下的情况下不断尝试增大k，
                        //当k增大到装不下时，当前位置的值就是之前存放在本位置的旧值，即dp[i][j]
                        dp[i][j] = dp[i][j];
                    }
                }
            }
        }
        for(int i = 0; i <= number; i++) {
            for(int j = 0; j <= capacity; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[number][capacity]);
    }


    /**
     * @Description: 完全背包问题的空间优化版，还可以利用转换为01背包的思路。
     * @Param:
     * @return:
     * @Author: co1de
     * @Date: 2019/6/5
     */
    public static void fullPackV2(int number,int capacity,int[] weigh,int[] value) {
        int[] dp = new int[capacity + 1];
        //初始化为0的步骤可以省略
        for (int i = 1; i <= number; i++) {
            for (int j = capacity; j >= 1; j--) {
                for (int k = 0; k <= capacity / weigh[i-1]; k++) {
                    if (j >= k*weigh[i-1]) {
                        //能装下
                        dp[j] = Math.max(dp[j - k * weigh[i-1]] + k * value[i-1], dp[j]);
                    } else {
                        dp[j] = dp[j];
                    }
                }
            }
        }
        for(int j = 0; j <= capacity; j++) {
            System.out.print(dp[j] + " ");
        }
        System.out.println();
        System.out.println(dp[capacity]);
    }

    /**
     * @Description: 完全背包问题的最优解法，
     * @Param:
     * @return:
     * @Author: co1de
     * @Date: 2019/6/5
     */
    public static void fullPackV3(int number,int capacity,int[] weigh,int[] value) {
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
            //注意这里是正序的，这是和01背包唯一不同的地方
            for (int j = 1; j<=capacity; j++) {
                if (j>=weigh[i-1]){
                    //能拿就从上一行两个位置中判断
                    f[j] = Math.max(f[j],f[j-weigh[i-1]]+value[i-1]);
                }else {
                    //不能拿就继承上一行
                    f[j] = f[j];
                }
            }
        }
        for(int j = 0; j <= capacity; j++) {
            System.out.print(f[j] + " ");
        }
        System.out.println();
        System.out.println(f[capacity]);
    }



    public static void main(String[] args) {
        int[] weight = {3,5,2,6,4}; //物品重量
        int[] val = {4,4,3,5,3}; //物品价值
//        int[] weight = {3,4,2}; //物品重量
//        int[] val = {4,5,3}; //物品价值
        int m = 12; //背包容量
        int n = 5; //物品个数
        zeroOnePackV1(n,m,weight,val);
        System.out.println("---------------------");
        zeroOnePackV2(n,m,weight,val);
        System.out.println("---------------------");
        fullPackV1(n,m,weight,val);
        System.out.println("---------------------");
        fullPackV2(n,m,weight,val);
        System.out.println("---------------------");
        fullPackV3(n,m,weight,val);
        System.out.println("---------------------");
    }
}
