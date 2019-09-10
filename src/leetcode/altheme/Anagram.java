package leetcode.altheme;

import java.util.ArrayList;
import java.util.Collections;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        ArrayList<Character> sa = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            sa.add(c);
        }
        ArrayList<Character> ta = new ArrayList<>();
        for (Character c : t.toCharArray()) {
            ta.add(c);
        }
        Collections.sort(sa);
        Collections.sort(ta);
        return ta.toString().equals(sa.toString());
    }
}
