package leetcode.altheme;

import newcode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleArr {
    private int[] row = null;
    private int[] arr = null;
    public ShuffleArr(int[] nums) {
        row = new int[nums.length];
        arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            row[i] = nums[i];
            arr[i] = nums[i];
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return row;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            tmp.add(arr[i]);
        }

        int[] ret = new int[arr.length];
        for (int i = 0; i < ret.length; i++) {
            int remove = new Random().nextInt(tmp.size());
            ret[i] = tmp.get(remove);
            tmp.remove(remove);
        }
        return ret;
    }
}
