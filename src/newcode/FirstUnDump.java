package newcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: offer
 * @description: 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 * @author: co1de
 * @create: 2019-06-10 21:00
 **/

public class FirstUnDump {
    private Queue<Character> res = new LinkedList<>();
    private int totalChar =0;
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (res.size()==0) res.add(ch);
        else {
            if (res.contains(ch)) {
                res.remove(ch);
            }else {
                res.add(ch);
            }
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        return res.isEmpty()?'#':res.peek();
    }
}
