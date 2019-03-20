package newcode;

import java.util.Iterator;

/**
 * @program: offer
 * @description: 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author: co1de
 * @create: 2019-03-20 21:22
 **/

public class SymmetryTree {

    /** 
    * @Description: 理解递归对功能实现的含义，只需将左右两边交给递归过程，并考虑递归最终终止条件，细节甚至可以不用考虑。
     * 思路：递归比较树的左右节点即可，注意是最左比最右，中间相比。
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/3/20 
    */ 
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot==null) return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left==null && right==null) return true;
        if (left==null || right==null) return false;
        if (left.val!=right.val) return false;
//        return isSymmetrical(left.left,right.right);
        return isSymmetrical(left.left,right.right) && isSymmetrical(left.right,right.left);
    }

    private TreeNode mirrorOpt(TreeNode pRoot) {
        TreeNode temp = null;
        if (pRoot!=null){
            temp = pRoot.left;
            pRoot.left=pRoot.right;
            pRoot.right=temp;
            mirrorOpt(pRoot.left);
            mirrorOpt(pRoot.right);
        }
        return pRoot;
    }

    public static void main(String[] args) {
        SymmetryTree st = new SymmetryTree();

    }
}
