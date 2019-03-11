package newcode;

/**
 * @program: offer
 * @description: 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @author: co1de
 * @create: 2019-03-08 19:31
 **/

public class RegexMatch {
    
    /** 
    * @Description: 思路与剑指offer上相同，不过是正向遍历，不知为啥过不去，哪里没考虑到，思路正确 
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/3/8 
    */ 
    public boolean match(char[] str, char[] pattern)
    {
        int k = 0;
        char temp=' ';
        int matchcount =0;
        for (int i=0;i<str.length&&k<pattern.length;){
            if (k+1<pattern.length && pattern[k+1]!='*'){
                if (str[i] == pattern[k] || pattern[k]=='.'){
                    matchcount++;
                    k++;
                    i++;
                }else return false;
            }else if (k+1<pattern.length && pattern[k+1]=='*'){
                if (pattern[k]=='.'){
                    //通配了。。
                    return true;
                }else {
                    temp = pattern[k];
                    if (str[i]==temp){
                        matchcount++;
//                        i++;
                        if (i+1<str.length && str[i] == str[i+1]){
                            i++;
                        }else {
                            k=k+2;
                        }
                    }else {
                        k=k+2;
                    }
                }
            }else {
                if (str[i] == pattern[k] || pattern[k]=='.') {
                    matchcount++;
                    k++;
                    i++;
                }

            }

        }

        if (matchcount==str.length && k>=pattern.length){
            return true;
        }else return false;
    }

    public static void main(String[] args) {
        RegexMatch rm = new RegexMatch();
        String a = "";
        String b = ".";
        System.out.println(rm.match(a.toCharArray(),b.toCharArray()));
    }
}
