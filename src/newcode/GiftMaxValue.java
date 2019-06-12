package newcode;

/**
 * @program: offer
 * @description: 链接：https://www.nowcoder.com/questionTerminal/72a99e28381a407991f2c96d8cb238ab 来源：牛客网  小东所在公司要发年终奖，而小东恰好获得了最高福利，他要在公司年会上参与一个抽奖游戏，游戏在一个6*6的棋盘上进行，上面放着36个价值不等的礼物，每个小的棋盘上面放置着一个礼物，他需要从左上角开始游戏，每次只能向下或者向右移动一步，到达右下角停止，一路上的格子里的礼物小东都能拿到，请设计一个算法使小东拿到价值最高的礼物。
 * @author: co1de
 * @create: 2019-06-12 11:03
 **/

public class GiftMaxValue {
    /** 
    * @Description: 利用dp思路来解决该问题，当前位置的最大值来自于上一个位置，上一个位置有两种来源，选取最大的，再加上本身价值 
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/6/12 
    */ 
    public int getMost(int[][] board) {
        int[][] dp = new int[board.length+1][board[0].length+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                //二维数组比一位数组大一圈，board下标要缩小
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]) + board[i - 1][j - 1];
            }
        }
        return dp[board.length][board[0].length];
    }

    /** 
    * @Description: 优化，考虑空间压缩，用一个一位数组，长度为棋盘列数。保存每i行的j个值
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/6/12 
    */ 
    public int getMost2(int[][] board) {
        int[] dp = new int[board.length+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                //dp保存的是每一列的最小值，递推公式变形
                //原来i,j的上放对应现在的j
                //原来ij的左边对应现在的j-1
                dp[j] = Math.max(dp[j], dp[j - 1]) + board[i - 1][j - 1];
            }
        }
        return dp[board.length];
    }

    public static void main(String[] args) {
        int[][] a = {{426,306,641,372,477,409},
                {223,172,327,586,363,553},
        {292,645,248,316,711,295},
            {127,192,495,208,547,175},
                {131,448,178,264,207,676},
                    {655,407,309,358,246,714}};
        System.out.println(new GiftMaxValue().getMost(a));
    }
}
