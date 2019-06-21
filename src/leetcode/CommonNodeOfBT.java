package leetcode;

/**
 * @program: offer
 * @description: leetcode number236
 * @author: co1de
 * @create: 2019-06-17 17:10
 **/

public class CommonNodeOfBT {
    /**
    * @Description: 和bst不同，这是普通二叉树，左右字数大小可能未知
    * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/6/17
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //采用先序的方式，来判断qp的位置
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left == null && right != null) {
            return right;
        } else if (right == null && left != null ) {
            return left;
        }
        return null;
    }
}
