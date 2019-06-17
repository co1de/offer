package newcode;

import java.util.LinkedList;

/**
 * @program: offer
 * @description: 每年六一儿童节, 牛客都会准备一些小礼物去看望孤儿院的小朋友, 今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * @author: co1de
 * @create: 2019-06-17 10:27
 **/

public class JosePhuseRing {
    /**
    * @Description: 思路1，利用环形链表模拟
    * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/6/17
    */
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        int count=0;
        //初始化
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        //开始转圈
        while (list.size() > 1) {
            //一次就走到当前位置的m-1的位置处
            count = (count+m-1)%list.size();
            list.remove(count);
        }
        return list.size()==1?list.get(0):-1;
    }

    /**
     * @Description: 未经空间压缩的方式
     * @Param:
     * @return:
     * @Author: co1de
     * @Date: 2019/6/17
     */
    public int LastRemaing_Solution2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int[] dp = new int[n+1];
        dp[1]= 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1]+m)%i;
        }
        return dp[n];
    }

    /**
    * @Description:利用约瑟夫环的公式解决。循环是自底向上实现的，采用了空间压缩的方式（dp[n]->dp）
    * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/6/17
    */
    public int LastRemaining_Solution3(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        //第一个数字报数为0
        int dp = 0;
        for (int i = 2; i <= n; i++) {
            dp = (dp+m)%i;
        }
        return dp;
    }

    /**
    * @Description: 递归实现
    * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/6/17
    */
    public int LastRemaining_Solution4(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        //返回条件
        if (n==1) return 0;
        return (LastRemaining_Solution4(n - 1, m)+m) % n;
    }




    public static void main(String[] args) {
        System.out.println(new JosePhuseRing().LastRemaining_Solution(5,3));
    }
}
