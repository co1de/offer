package newcode;

/**
 * @program: offer
 * @description: 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @author: co1de
 * @create: 2019-06-15 21:30
 **/

public class OnceNumberInArray {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int a = array[0];
        //相同的都异或成0了
        for (int i = 1; i < array.length; i++) {
            a ^= array[i];
        }
        //找到一个1来作区分
        //一个牛逼的区分方式：diff &= -diff 得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
        int count = 0;
        while (a!=0) {
            if ((a=a >>> 1) == 1) {
                break;
            }
            count++;
        }
        count++;
        int p = 1<<count;
        //开始区分
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & p) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2,3,4,6,3,2,5,5};
        int[] b = new int[1];
        int[] c = new int[1];

        new OnceNumberInArray().FindNumsAppearOnce(a, b, c);
        System.out.println(b[0]+" "+c[0]);

        System.out.println();
    }
}
