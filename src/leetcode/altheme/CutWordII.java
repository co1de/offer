package leetcode.altheme;

import java.util.*;

public class CutWordII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ret = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] viz = new int[s.length()];
        String temp = "";
        stack.add(0);
        while (!stack.isEmpty()) {
            int start = stack.pop();
            if (viz[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDict.contains(s.substring(start, end))) {
                        temp=s.substring(start,end)+" ";
                        stack.add(end);
                        break;
                    }
                }
                viz[start]=1;
            }
        }

        return ret;
    }
}
