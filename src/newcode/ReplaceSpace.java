package newcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * */
public class ReplaceSpace {
    public static void main(String[] args) {
        String s = "";
        String[] ss = s.split(" ");
        System.out.println(replaceSpace(new StringBuffer(s)));
        Integer a =128;
        Integer b =128;
        System.out.println(a==b ? "equal":"not");
    }
    public static String replaceSpace(StringBuffer str) {
        for (int i=0;i<str.length();i++){
            if (str.charAt(i) == ' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
//        if (str.length() == 0) return str.toString();
//        String[] cuts = str.toString().split(" ");
//        StringBuffer result = new StringBuffer();
//        for (int i=0;i<cuts.length;i++){
//            if (i<cuts.length-1){
//                result.append(cuts[i]);
//                result.append("%20");
//            }else {
//                result.append(cuts[i]);
//            }
//
//        }
//        if (str.lastIndexOf(" ") == str.length()-1){
//            result.append("%20");
//        }
//        return result.toString();
    }

}
