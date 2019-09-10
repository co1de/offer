package leetcode.altheme;

public class RotateArr {
    public void rotate(int[] nums, int k) {
        int temp=0;

        for (int i = 0; i < k; i++) {
            int pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = pre;
                pre= temp;
            }
        }
    }
    public void rotate1(int[] nums, int k) {
        int temp=0;

        for (int i = 0; i < k; i++) {
            int pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = pre;
                pre= temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        new RotateArr().rotate(a, 3);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
