package leetcode.altheme;

public class Title2Number {
    public int titleToNumber(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            ret = ret*26 + num;
        }
        return ret;
    }
}
