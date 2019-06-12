package newcode;

/**
 * @program: offer
 * @description: 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * @author: co1de
 * @create: 2019-06-11 17:22
 **/

public class DecodeWays {
    /**
    * @Description: 分析我们可以发现，该题是dp问题，dp[i]=dp[i-1]+dp[i-2]*(10-25?1:0)
    * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/6/11
    */
    public int numDecodings(String s) {
        if (s.equals("0")) return 0;
        int[] dp = new int[s.length()+1];
        dp[1]=1;
        for (int i = 2; i < s.length(); i++) {
            if (Integer.valueOf(s.substring(i-1,i))>=1 && Integer.valueOf(s.substring(i-1,i))<=26){
                dp[i] = dp[i-1] + dp[i - 2];
            }else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    /** 
    * @Description: 是一个有限制条件的爬台阶问题，要做合法性判断
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/6/12 
    */ 
    public int numDecodings2(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        //注意初始化这里
        dp[0] = 1;
        //第一位不能为0
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            //注意dp[i]对应的s位置为s[i-1]，每次需要将i-1割出来和i-2割出来，即前一位和前两位割出来
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            //合法性判断
            if(first >= 1 && first <= 9) {
                dp[i] = dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        String s = "12258";
        System.out.println(new DecodeWays().numDecodings2(s));
    }
}
