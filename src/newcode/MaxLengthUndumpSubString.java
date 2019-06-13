package newcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: offer
 * @description: 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 * @author: co1de
 * @create: 2019-06-12 19:31
 **/

public class MaxLengthUndumpSubString {

    public int lengthOfLongestSubstring(String s) {
        int start =0;
        int curMax = 0;
        int max = 0;
        HashMap<Character, Integer> pos = new HashMap<>();
        //当字符为0-9 A-Z a-z时这样的表会覆盖记录。。改用哈希表
//        int[] charpos = new int [256];
//        Arrays.fill(charpos,-1);
        for (int i = 0; i < s.length(); i++) {
//            int t = charpos[Math.abs(s.charAt(i) - 'a')];
            int t = pos.get(s.charAt(i))==null?-1:pos.get(s.charAt(i));
            if (t >= 0) {
//                int dis = Math.abs(i-charpos[Math.abs(s.charAt(i) - 'a')]);
                int dis = i - pos.get(s.charAt(i));
                if (dis > curMax) {
                    //i在被忽略的范围外，可以继续计算
                    curMax ++;
                } else {
                    curMax = dis;
                }
            } else {
                //没出现
                curMax++;
            }
//            charpos[Math.abs(s.charAt(i) - 'a')]=i;
            pos.put(s.charAt(i), i);
            max = Math.max(max, curMax);

        }
        //防止最后一次max没更新
        max = Math.max(max, curMax);
        return max;
    }

    public static void main(String[] args) {
        String a = "pwwkew";
        String b = "abcabcbb";
        String c = "hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        System.out.println(new MaxLengthUndumpSubString().lengthOfLongestSubstring(c));
    }
}
