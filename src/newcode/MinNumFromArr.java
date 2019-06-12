package newcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: offer
 * @description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author: co1de
 * @create: 2019-06-11 17:01
 **/

public class MinNumFromArr {
    public String PrintMinNumber(int [] numbers) {
        PriorityQueue<String> min = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //定义排序规则，决定哪个放在前面
                return (o1+o2).compareTo(o2+o1);
            }
        });
        for (int num :
                numbers) {
            min.add(String.valueOf(num));
        }
        StringBuilder sb = new StringBuilder();
        while (min.size() > 0) {
            sb.append(min.poll());
        }
        return sb.toString();
    }
}
