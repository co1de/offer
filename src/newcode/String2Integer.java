package newcode;

/**
 * @program: offer
 * @description: 将一个字符串转换成一个整数(实现Integer.valueOf ( string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * @author: co1de
 * @create: 2019-06-17 16:27
 **/

public class String2Integer {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int ret=0;
        boolean negative = str.charAt(0)=='-'?true:false;
        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            if (i == 0 && (t == '+' || t == '-')) {
                continue;
            }
            if (t < '0' || t > '9') {
                return 0;
            }
            ret = t-'0'+ret*10;
        }
        return negative==true?-ret:ret;
    }
}
