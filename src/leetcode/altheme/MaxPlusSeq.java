package leetcode.altheme;

public class MaxPlusSeq {
    public int maxProduct2(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        int ret =nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]<0) {
                int temp = curMax;
                curMax=curMin;
                curMin = temp;
            }
            curMax = Math.max(curMax * nums[i], nums[i]);
            curMin = Math.min(curMin * nums[i], nums[i]);
            ret = Math.max(curMax, ret);
        }
        return ret;
    }
    public int maxProduct3(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        int ret =nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                curMax = Math.max(curMax * nums[i], nums[i]);
                curMin = Math.min(curMin * nums[i], nums[i]);
            } else {
                int oldMax = curMax;
                curMax = Math.max(curMin * nums[i], nums[i]);
                curMin = Math.min(oldMax * nums[i], nums[i]);
            }
            ret = Math.max(curMax, ret);
        }
        return ret;
    }
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length + 1];
        int[] dpMin = new int[nums.length + 1];
        dpMax[0] = 1;
        dpMin[0] = 1;
        for (int i = 1; i < dpMax.length; i++) {
            if (nums[i] > 0) {
                dpMax[i] = Math.max(dpMax[i - 1] * nums[i - 1], nums[i - 1]);
            } else {
                dpMin[i] = Math.min(dpMin[i - 1] * nums[i - 1], nums[i - 1]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < dpMax.length; i++) {
            if (dpMax[i] > max) {
                max = dpMax[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        int[] arr1 = {-2};
        int[] arr2 = {0,2};
        int[] arr3 = {3,-1,4};
        int[] arr4 = {-2,-3,-4};
        System.out.println(new MaxPlusSeq().maxProduct3(arr4));
    }
}
