package leetcode.altheme;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix[0].length - 1];
        int mid = 0;
        int count=0;
        while (low < high) {
            mid = (low + high) / 2;
            count=0;
            for (int i = 0; i < matrix.length; i++) {
                count += getCount(matrix[i], mid);
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high=mid;
            }
        }
        return low;
    }

    private int getCount(int[] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;
        int middle =0;
        while (low < high) {
            middle = (low + high) / 2;
            if (matrix[middle] > target) {
                high=middle;
            } else {
                low=middle+1;
            }
        }
        return low;
    }
}
