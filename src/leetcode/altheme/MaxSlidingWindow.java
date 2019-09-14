package leetcode.altheme;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int start=0;
        int curMax = Integer.MIN_VALUE;
        while (start <k) {
            if (nums[start] > curMax) {
                map.clear();
                map.put(nums[start], start);
                curMax = nums[start];
            }
            start++;
        }
        int beforeMaxPos = 0;
        while (start < nums.length) {
            if (nums[start] > curMax) {
                beforeMaxPos = map.get(curMax);
                if ((start - beforeMaxPos) > k) {
                    map.clear();
                    map.put(nums[start], start);
                } else {
                    map.clear();
                    map.put(nums[start], start);
                }
            }
        }
        return null;
    }
}
