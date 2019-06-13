package newcode;

/**
 * @program: offer
 * @description: 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @author: co1de
 * @create: 2019-06-13 12:00
 **/

public class UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        int count=0;
        int i=1;
        while (count < index) {
            if (judgeUgly(i++)) {
                count++;
            }
//            i++;
        }
        return --i;
    }
    private boolean judgeUgly(int i) {
        while (i % 2 == 0) {
            i = i / 2;
        }
        while (i % 3 == 0) {
            i = i /3;
        }
        while (i % 5 == 0) {
            i = i /5;
        }
        if (i == 1) {
            return true;
        }else return false;
    }

    public int GetUglyNumber_Solution2(int index) {
        //不是去判断丑数，而是去生成丑数，因为丑数都是235生成的
        //这种思路的关键是要让生成的丑数排好序
        int[] res = new int[index+1];
        if (index == 0) {
            return res[index];
        }
        res[1]=1;
        int start2=1,start3=1,start5=1;
        for (int i = 2; i <= index; i++) {
            int i2 = res[start2] * 2, i3 = res[start3] * 3, i5 = res[start5] * 5;
            int min = Math.min(i2, Math.min(i3, i5));
            res[i] = min;
            if (res[i]==res[start2]*2) start2++;
            if (res[i]==res[start3]*3) start3++;
            if (res[i]==res[start5]*5) start5++;
        }
        return res[index];
    }
    public static void main(String[] args) {
        System.out.println(new UglyNumber().GetUglyNumber_Solution(1));
    }
}
