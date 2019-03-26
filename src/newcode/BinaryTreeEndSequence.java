package newcode;

/**
 * @program: offer
 * @description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @author: co1de
 * @create: 2019-03-26 19:43
 **/

public class BinaryTreeEndSequence {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null || sequence.length==0) return false;
        return verify(0, sequence.length - 1, sequence);
    }

    private boolean verify(int start, int end, int[] sequence) {
//      单节点直接返回true
        if (end-start<1) return true;
        //当前根节点
        int root = sequence[end];
        //找到左子树
        int leftend=0;
        for (int i=start;i<=end;i++) {
            //题目中规定数字不相同，不用考虑相等
            if (sequence[i]<root){
                leftend++;
            }else {
                break;
            }
        }
        leftend=start+leftend-1;
        //找到右子树
        int right=0;
        //注意这里是end-1，不用判断根节点
        for (int i=leftend+1;i<=end-1;i++) {
            //题目中规定数字不相同，不用考虑相等
            if (sequence[i]>root){
                right++;
            }else {
//                右子树不会有比根节点更小的
                return false;
            }
        }
        right=leftend+right;
        return verify(start,leftend,sequence) && verify(leftend+1,right,sequence);
    }

    public static void main(String[] args) {
        BinaryTreeEndSequence bstS = new BinaryTreeEndSequence();
        int[] a = {4,8,6,12,16,14,10};
        int[] a1 = {4,6,7,5};

        System.out.println(bstS.VerifySquenceOfBST(a));
    }
}
