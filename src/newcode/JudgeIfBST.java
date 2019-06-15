package newcode;

/**
 * @program: offer
 * @description: 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @author: co1de
 * @create: 2019-06-15 21:19
 **/

public class JudgeIfBST {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root != null) {
            int left = TreeDepth(root.left);
            int right = TreeDepth(root.right);
            if (Math.abs(right - left) > 1) {
                return false;
            }
        }
        return true;
    }

    public int TreeDepth(TreeNode root) {
        int ret=0,left=0,right=0;
        if (root == null) {
            return ret;
        }
        if (root.left != null) {
            left = TreeDepth(root.left);
        }
        if (root.right != null) {
            right = TreeDepth(root.right);
        }
        return Math.max(left,right)+1;
    }
}
