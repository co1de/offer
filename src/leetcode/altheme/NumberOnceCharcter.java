package leetcode.altheme;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NumberOnceCharcter {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (Character c : s.toCharArray()) {
            int temp = 0;
            if (map.get(c) == null) {
                temp = 0;
            } else {
                temp = map.get(c);
            }
            map.put(c, ++temp);
        }
        Character goal = null;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                goal = e.getKey();
                break;
            }
        }
        if (goal == null) {
            return -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == goal.charValue()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOnceCharcter().firstUniqChar("cc"));
    }
}
