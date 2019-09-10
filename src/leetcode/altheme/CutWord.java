package leetcode.altheme;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CutWord {
    public boolean wordBreakMyFault(String s, List<String> wordDict) {
        if (wordDict.size()==0) return false;
        String myS = new String(s);
        String temp = null;
        int count =1;
        while (myS.length() > 0 && count==1) {
//            count=0;
            for (String each:wordDict) {
                count=0;
                if (each.length() > myS.length()) {
                    temp = "";
                } else {
                    temp = myS.substring(0, each.length());
                }

                if (temp.equals(each)) {
                    count=1;
                    myS = myS.substring(each.length());
                    break;
                }

            }
        }
        return myS.length() > 0 ? false : true;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return cut(s, wordDict, 0);
    }

    private boolean cut(String s, List<String> wordDict, int start) {
        if (start == s.length()) {
//            if (wordDict.contains(s)) {
                return true;
//            } else {
//                return false;
//            }
        }
        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i)) && cut(s, wordDict, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        int[] vis = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (vis[start] == 0) {
                for (int end = start+1; end <= s.length(); end++) {
                    if (wordDict.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                vis[start]=1;
            }
        }
        return false;
    }



        public static void main(String[] args) {
//        System.out.println("leet".split("leet"));
        ArrayList<String> ar = new ArrayList<>();
        ar.add("cats");
        ar.add("dog");
        ar.add("sand");
        ar.add("and");
        ar.add("cat");
        ArrayList<String> arr = new ArrayList<>();
        arr.add("apple");
        arr.add("pen");
        ArrayList<String> arrr = new ArrayList<>();
        arrr.add("leet");
        arrr.add("code");
        System.out.println(new CutWord().wordBreak("leetcode",arrr));
    }
}
