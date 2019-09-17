package leetcode.altheme;

import java.util.HashMap;
import java.util.Set;

public class RandomizedSet {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int MAX= Integer.MIN_VALUE;
    private int MIN = Integer.MAX_VALUE;
    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (val > MAX) {
            MAX = val;
        }
        if (val < MIN) {
            MIN = val;
        }
        if (map.containsKey(val)) {
            map.put(val, val);
            return false;
        } else {
            map.put(val, val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {

        if (map.containsKey(val)) {
            map.remove(val);
            return false;
        } else {
            map.remove(val);
            return true;
        }
//        new Set<>().toArray()
    }

    /** Get a random element from the set. */
//    public int getRandom() {
//    }
}
