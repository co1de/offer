package newcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @program: offer
 * @description: 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @author: co1de
 * @create: 2019-04-18 20:58
 **/

public class StringArrange {
    private ArrayList<String> ret = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        char[] t = str.toCharArray();
//        Arrays.sort(t);
        permutation(t, 0, str.length()-1);
        //结果要是字典序..
        Collections.sort(ret);
        return ret;
    }

    private void permutation(char[] chars, int start, int end) {
        if (start == end) {
            ret.add(String.valueOf(chars));
        }else {
            for (int i=start;i<=end;i++){
                if (judge(chars,start,i)){
                    swap(chars,start,i);
                    permutation(chars, start + 1, end);
                    swap(chars,start,i);
                }
            }
        }
    }

    private boolean judge(char[] chars, int start, int i) {
        for (int j=start;j<i;j++) {
            if (chars[j] == chars[i]){
                return false;
            }
        }
        return true;
    }

    private void swap(char[] chars,int i,int j) {
        char temp;
        temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
