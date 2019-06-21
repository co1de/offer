package newcode;

import java.util.LinkedList;

/**
 * @program: offer
 * @description: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author: co1de
 * @create: 2019-06-18 09:10
 **/

public class RebuildBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length <= 0 || in.length <= 0) {
            return null;
        }
        return reConstructBinaryTree(pre, 0,pre.length - 1,
                in, 0,in.length - 1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int preStart,int preEnd,
                                          int[] in, int inStart,int inEnd) {
        if (preEnd < preStart || inEnd < inStart) {
            return null;
        }
        //前序第一个就是根节点
        TreeNode root = new TreeNode(pre[preStart]);
        //找到左子树长度
        int step = 0;
        for (int i = inStart; i <= inEnd; i++,step++) {
            if (in[i] == root.val) {
                break;
            }
        }
        //递归创建左右子树
        root.left = reConstructBinaryTree(pre,preStart+1,preStart+1+step-1,
                in,inStart,inStart+step-1);

        root.right = reConstructBinaryTree(pre,preStart+step+1,preEnd,
                in,inStart+step+1,inEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        TreeNode ret = new RebuildBinaryTree().reConstructBinaryTree(pre, in);
        LinkedList<TreeNode> ll = new LinkedList<>();
        ll.add(ret);
        while (ll.size() > 0) {
            ll.add(ret.left);
            ll.add(ret.right);
            System.out.print(ll.poll()+" ");
            ret = ll.peek();
        }
    }
}
