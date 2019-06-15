package newcode;

import javax.swing.tree.TreePath;

/**
 * @program: offer
 * @description: 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @author: co1de
 * @create: 2019-06-15 21:10
 **/

public class DepthOfTree {
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
