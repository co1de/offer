package newcode;

/**
 * @program: offer
 * @description: 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author: co1de
 * @create: 2019-03-09 20:44
 **/

public class RegexMatch2 {
    public boolean isNumeric(char[] str) {
        int pointCount=0;
        boolean flag = false;
        if (str==null || str[0]==' ') return false;
//        if (str[0]=='+' || str[0]=='-')
        for (int i=0;i<str.length;i++){
            if (str[i]=='+'){
                //出现在非开头或开头后有非法字符的,或前面不是e的
                if ( (i+1<str.length && str[i+1]=='-')
                        || (i-1>=0 && (str[i-1]!='e' && str[i-1]!='E'))) return false;
            }else if (str[i]=='-'){
                //出现在非开头或-号前不是e或E的都不是i!=0 ||
                if ( (i-1>0 && (str[i-1]!='e' && str[i-1]!='E'))) return false;
            }else if ((str[i]<'0'||str[i]>'9') && (str[i]!='e' && str[i]!='E'&& str[i]!='.')){
//                是非合法字符的，直接返回假
                return false;
            }else if (str[i]=='.'){
                pointCount++;
                //flag用来控制指数位置不能是小数
                if (pointCount>1 || flag) return false;
            }else if (str[i]=='e'||str[i]=='E'){
                flag=true;
                if (i==0 || (i+1==str.length)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RegexMatch2 rm2 = new RegexMatch2();
        String s = "12e+5.4";
        System.out.println(rm2.isNumeric(s.toCharArray()));
    }
}
