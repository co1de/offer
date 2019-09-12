package leetcode.altheme;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = k * nums[i-1];
            k = res[i];
        }
        k = 1;
        for (int i = res.length-1; i >=0 ; i--) {
            res[i] = k * res[i];
            k *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        arr = new ProductExceptSelf().productExceptSelf(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
