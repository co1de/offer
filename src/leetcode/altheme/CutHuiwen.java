package leetcode.altheme;

import java.util.ArrayList;
import java.util.List;

public class CutHuiwen {
//    private List<List<String>> ret = new ArrayList<>();
    public List<List<String>> partition(String s) {
        return cut(s,0);
    }

    private List<List<String>> cut(String s,int start) {
        //out
        if (start >= s.length()) {
            List<List<String>> ret = new ArrayList<>();
            List<String> eachAns = new ArrayList<>();
            ret.add(eachAns);
            return ret;
        }
        //judge
        List<List<String>> ans = new ArrayList<>();
        for (int i = start+1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(start, i))) {
                String cur = s.substring(start, i);
                for (List<String> l : cut(s, i)) {
                    l.add(0, cur);
                    ans.add(l);
                }
            }
        }

        //return to up
        return ans;
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z' || c>='0'&& c<='9') {
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
