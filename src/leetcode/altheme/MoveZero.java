package leetcode.altheme;

public class MoveZero {
    public void moveZeroes(int[] nums) {
        int end=nums.length-1;
        int zeroPos = end;
        int pre = 0;
        int temp =0;
        for (int i = end; i >= 0; i--) {
            zeroPos=i;
            while (zeroPos>=0 && nums[zeroPos] != 0) {
                zeroPos--;
            }
            if (zeroPos < 0) {
                break;
            }
            for (int j = zeroPos+1; j <=i ; j++) {
                temp = nums[j];
                nums[j]= nums[zeroPos];
                nums[zeroPos]=temp;
                zeroPos++;
            }

        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        new MoveZero().moveZeroes(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
