package newcode;

/**
 * @program: offer
 * @description: 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author: co1de
 * @create: 2019-06-17 15:38
 **/

public class DoAddWithoutKeyword {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n>0) && ((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}
