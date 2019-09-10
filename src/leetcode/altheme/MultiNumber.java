package leetcode.altheme;

public class MultiNumber {
    public static int majorityElement(int[] nums) {
        if (nums.length==1) return nums[0];
        int ret = 0;
        int pos = partation(nums, 0, nums.length - 1);
        int start = 0;
        int end = nums.length-1;
        if (pos < nums.length / 2) {
            ret = partation(nums, pos+1, end);
        } else if (pos > nums.length / 2) {
            ret = partation(nums, start, pos - 1);
        } else {
            ret = pos;
        }
        return nums[ret];
    }

    private static int partation(int[] arr,  int start, int end) {
        int piort = arr[start];
        int low = start;
        int high = end+1;
        while (low < high) {
            while (low<end && arr[++low] < piort) {
//                low++;
            }
            while (high>start && arr[--high] > piort) {
//                high--;
            }
            if (low>=high) break;
            exchange(arr, low, high);
        }
        exchange(arr,start,high);
        return high;
    }

    private static void exchange(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public int majorityElement2(int[] nums) {
        int curMajor = nums[0];
        int vote=1;
        for (int i = 1; i < nums.length; i++) {
            if (vote == 0) {
                curMajor = nums[i];
            }
            if (nums[i] == curMajor) {
                vote++;
            } else {
                vote--;
            }
        }
        return curMajor;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        int[] arr1 = {3,3,4};
        int[] arr2 = {4,5,4};
        int[] arr3 = {10,9,9,9,10};
        int[] arr4 = {3,2,3};
        int[] arr5 = {6,5,5};
        int[] arr6 = {6,6,6,7,7};
        System.out.println(majorityElement(arr3));
     }
}
