package leetcode;
/**
 * Given a positive integer n,
 * break it into the sum of at least two positive integers and maximize the product of those integers.
 * Return the maximum product you can get.
 * 本题和剪绳子一样，使得每段乘积最大
 * */
public class IntegerBreak {
    /**
     * 自然想到dp，令fn表示长为n的数字能获得的最大值
     * 第一次分割，会有两段，每段都有最大值，两端最大值的积即为当前n的最大值，这里就是最优子结构
     * 而且每个问题都有更小的子问题，这就是重叠子问题，这样满足了dp的条件
     * 自顶向下需要记录递归结果，可能造成重复运算，编码采用自底向上，记录子问题最优解。
     * 递归式为fn = man（fn*f（n-i）），其中i>1（即绳子、数最小也是1）
     */
    public int integerBreak(int n) {
        if(n==2){
            return 1;
        }
        if(n<2){
            return 0;
        }
        if (n==3){
            return 2;
        }
        int max = 0;
        //记录子问题最优解
        //注意要比n多一个，因为有个0占了一位
        int[] f = new int[n+1];
        //初始化条件
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        //最小从4开始循环,注意结束要为n，否则算不到n就没了。。。
        for (int i=4;i<=n;i++){
            //清空max，重新计算n为i时的最优解
            max = 0;
            //只用算一半，后面情况和前面对称了。
            for (int j=1;j<=i/2;j++){
                int tempMax = f[j]*f[i-j];
                if (tempMax>max){
                    max = tempMax;
                }
            }
            f[i]=max;
        }
        return f[n];
    }

    /**
     * leetcode中第二个提示，该问题经过数学分析还可以用贪心算法
     * 我们发现5以后最大值总是2与3的组合，当然3越多越好，这样我们便有了贪心的想法
     * 每次尽可能多的切割出长度为3的绳子,
     * 3 3 1 的组合小于3 2 2 ，所以如果余1的时候我们让出一个1补成2
     * */
    public int integerBreak2(int n){
        if(n==2){
            return 1;
        }
        if(n<2){
            return 0;
        }
        if (n==3){
            return 2;
        }
        //计算可以切出几个3
        int count3 = n/3;
        //看剩下多长
        int last = n % 3;
        //余数只有三种可能
        if(last==1){
            //由于331小于322，因此让出一个1
            count3--;
            return (int) (Math.pow(3,count3)*4);
        }else if(last==2){
            //最后剩2
            return (int) (Math.pow(3,count3)*2);
        }else {
//            整除
            return (int) (Math.pow(3,count3));
        }

    }


    public static void main(String[] args) {
        IntegerBreak ib = new IntegerBreak();
        System.out.println(ib.integerBreak(10));
        System.out.println(ib.integerBreak2(10));
    }
}
