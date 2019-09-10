package leetcode.altheme;

import java.util.HashMap;
import java.util.Map;

public class DuplicateInArr {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = map.get(nums[i])==null?0:map.get(nums[i]);
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 0);
            } else {
                map.put(nums[i], ++temp);
                return true;
            }
        }
        return false;
    }
}
