package newcode;

/**
 * @program: offer
 * @description: 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @author: co1de
 * @create: 2019-06-16 11:23
 **/

public class ReverseString {
    public String ReverseSentence(String str) {
        //这样写有问题，如果碰到多个空格会通不过
        if (str == null) {
            return null;
        }
        String[] cut = str.split(" ");
        String[] temp = new String[cut.length];
        int back = temp.length-1;
        for (String s:cut) {
            temp[back--]=s;
        }

        String ret = "";

        for (String s:
             temp) {
            ret+=s+" ";
        }
        //取出空格
        if (str.length()==1) return str;
        return ret.substring(0,ret.length()-1);
    }

    public String ReverseSentence2(String str) {
        char[] c = new char[str.length()];
        int back =c.length-1;
        //先将整个句子翻转
        for (int i = 0; i < str.length(); i++) {
            c[i] = str.charAt(back--);
        }
        //再反转每个单词，以空格为界分割
        int start = 0;
        int end =0;
        while (end<=c.length) {
            //防止只有一单词,循环取等和这里取到了length，且放在前面防止后方数组越界
            if (end==c.length || c[end] == ' ') {
                int i=start,j=end-1;
                //不交换空格，不取等
                while (i <= j) {
                    exchange(c,i++,j--);
                }
                start=end+1;
            }
            end++;
        }
        return new String(c);
    }

    public void exchange(char[] c, int start, int end) {
        char t = c[start];
        c[start] = c[end];
        c[end] = t;
    }

    public static void main(String[] args) {
        String s = "i am a student.";
        String ss = " ";
        System.out.println(new ReverseString().ReverseSentence2(s));
    }
}
