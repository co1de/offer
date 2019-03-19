package newcode;

/**
 * @program: offer
 * @description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author: co1de
 * @create: 2019-03-19 20:02
 **/

public class TreeSubArch {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
//        if (root1==null || root2== null)  return false;
        boolean flag = false;
        if (root1!=null && root2!=null){
            //如果相等，继续判断
            if (root1.val==root2.val){
                flag = HaveTree(root1, root2);
            }
            //如果不相等，判断左边
            if (!flag){
                flag = HasSubtree(root1.left,root2);
            }
            //如果不相等，判断右边
            if (!flag){
                flag = HasSubtree(root1.right, root2);
            }
        }
        return flag;
    }

    private boolean HaveTree(TreeNode root1, TreeNode root2) {
//  需要先判断右子树是否结束，若右子树已经判断完了还相等，即右边含在左边内。
        if (root2==null) return true;
        if (root1==null) return false;
        if (root1.val!= root2.val){
            return false;
        }
        return HaveTree(root1.left,root2.left) && HaveTree(root1.right,root2.right);
    }

    public static void main(String[] args) {
        TreeSubArch t = new TreeSubArch();
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(9);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;

        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(2);
        t1.left=t2;
        t1.right=t3;


        System.out.println(t.HasSubtree(n1,t1));
    }
}
