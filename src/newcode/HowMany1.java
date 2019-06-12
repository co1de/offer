package newcode;

/**
 * @program: offer
 * @description: 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * @author: co1de
 * @create: 2019-06-11 16:28
 **/

public class HowMany1 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int res=0;
        for (int i = 1; i <= n; i++) {
            //基础思路，判断每一个数的情况
            res += getNumber(i);
        }
        return res;
    }

    private int getNumber(int i) {
        int count=0;
        while (i > 0) {
            if (i % 10==1) {
                count++;
            }
            i = i / 10;
        }
        return count;
    }

    public int NumberOf1Between1AndN_Solution2(int n) {
        return 0;
    }

}
