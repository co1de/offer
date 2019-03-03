package newcode;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * */
public class Step {
    public static void main(String[] args) {
        System.out.println(JumpFloorII(3));
    }
    public static int JumpFloor(int target) {
        if (target == 1) return 1;
        else if (target ==2) return 2;
        else return JumpFloor(target-1)+JumpFloor(target-2);
    }

    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public static int JumpFloorII(int target) {
        int temp = 4;
        int sum =0;
        if (target == 1) return 1;
        else if (target ==2) return 2;
        else {
            for (int i=3;i<=target;i++){
                sum = sum +temp;
                temp = sum;
            }
        }
        return sum;
    }
}
