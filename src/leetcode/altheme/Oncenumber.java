package leetcode.altheme;

public class Oncenumber {
    public static int singleNumber(int[] nums) {
        int curOnce = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curOnce = curOnce | nums[i];
        }
        return curOnce;
    }
}
