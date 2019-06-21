package leetcode;

/**
 * @program: offer
 * @description: Say you have an array for which the ith element is the price of a given stock on day i.  If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.  Note that you cannot sell a stock before you buy one.
 * @author: co1de
 * @create: 2019-06-17 15:21
 **/

public class MaxProfit {
    /** 
    * @Description: 思路：记录之前最小的值，用后面出现的值与其做差，取最大的记录，若后面的值有更小的，更新最小值
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/6/17 
    */ 
    public int maxProfit(int[] prices) {
        //意外条件。
        if (prices==null || prices.length<1) return 0;
        int maxDiff = 0;
        int minBefore = prices[0];
        for (int i = 1; i < prices.length; i++) {
            //记录最大差值
            maxDiff = maxDiff < prices[i]-minBefore?prices[i] - minBefore:maxDiff;
            //判断是否更新之前的最小值
            minBefore = minBefore < prices[i] ? minBefore : prices[i];
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] a = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(new MaxProfit().maxProfit(a));
    }
}
