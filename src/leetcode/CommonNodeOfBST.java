package leetcode;

/**
 * @program: offer
 * @description: leetcode number 235
 * @author: co1de
 * @create: 2019-06-17 16:46
 **/

public class CommonNodeOfBST {
    /**
    * @Description: 可以看出公共父节点应大于左节点，小于右节点,
    * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/6/17
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        //考虑使用前序遍历的方式
        //注意因为不知道pq谁是左右节点，需要保证取全
        if (root.val >= Math.min(p.val,q.val) && root.val <= Math.max(p.val,q.val)) {
            return root;
        } else if (root.val > p.val && root.val>q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < q.val && root.val<p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }
}
