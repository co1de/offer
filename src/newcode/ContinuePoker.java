package newcode;

/**
 * @program: offer
 * @description: LL今天心情特别好, 因为他去买了一副扑克牌, 发现里面居然有2个大王, 2个小王(一副牌原本是54张 ^ _ ^)...他随机从中抽出了5张牌, 想测测自己的手气, 看看能不能抽到顺子, 如果抽到的话, 他决定去买体育彩票, 嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 * @author: co1de
 * @create: 2019-06-17 09:49
 **/

public class ContinuePoker {
    public boolean isContinuous(int [] numbers) {
        //至少得有五张牌
        if (numbers.length < 5) {
            return false;
        }
        //使用冒泡排序
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (j+1<numbers.length && numbers[j]>numbers[j+1]){
                    int t = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j + 1] = t;
                }
            }
        }
        //找到万能牌后面的位置,并统计万能牌次数
        int count=0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                count++;
            } else {
                break;
            }
        }
        //查看其他牌是否连续，即查看间隔是否小于万能牌个数。
        int start = count;
        int after = start+1;
        int gap = 0;
        while (after < numbers.length) {
            //不能有相同的牌
            if (numbers[after] == numbers[start]) {
                return false;
            }
            gap += numbers[after]-numbers[start]-1;
            start++;
            after++;
        }
        //或写成gap<=count
        return gap>count?false:true;
    }
}
