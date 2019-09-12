package leetcode.altheme;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrIntersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int minLength = Math.min(nums1.length, nums2.length);
        ArrayList<Integer> ret = new ArrayList<>();
        int one = 0;
        int two = 0;
        while (one < nums1.length && two < nums2.length) {
            if (nums1[one] < nums2[two]) {
                one++;
            } else if (nums2[two] < nums1[one]) {
                two++;
            } else if (nums1[one] == nums2[two]) {
                ret.add(nums1[one]);
                one++;
                two++;
            }
        }
        int[] retArr = ret.stream().mapToInt(Integer::intValue).toArray();
        return retArr;
    }
}
