package leetcode.altheme;

public class MergeArr {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ret = new int[m + n];
        int k=0;
        int p1=0;
        int p2=0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] <= nums2[p2]) {
                ret[k++] = nums1[p1++];
            } else if (nums1[p1] > nums2[p2]) {
                ret[k++] = nums2[p2++];
            }
        }

        if (p1 < m) {
            for (int i = p1; i < m; i++) {
                ret[k++] = nums1[i];
            }
        }
        if (p2 < n) {
            for (int i = p2; i < n; i++) {
                ret[k++] = nums2[i];
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = ret[i];
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        new MergeArr().merge(num1,3,num2,3);
    }
}
