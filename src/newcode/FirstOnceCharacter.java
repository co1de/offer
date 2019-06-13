package newcode;

/**
 * @program: offer
 * @description: 在一个字符串(0 < = 字符串长度 < = 10000 ， 全部由字母组成)中找到第一个只出现一次的字符, 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * @author: co1de
 * @create: 2019-06-13 20:04
 **/

public class FirstOnceCharacter {
    public int FirstNotRepeatingChar(String str) {
        int ret = -1;
        int[] hash = new int[256];
        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (hash[str.charAt(i)]==1) {
                return i;
            }
        }
        return ret;
    }
}
