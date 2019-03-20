package newcode;

/**
 * @program: offer
 * @description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @author: co1de
 * @create: 2019-03-20 21:11
 **/

public class MirrorTree {
    public void Mirror(TreeNode root) {
        if (root!=null){
            exchange(root,root.left,root.right);
            Mirror(root.left);
            Mirror(root.right);
        }
    }

    private void exchange(TreeNode root,TreeNode left, TreeNode right) {
        if (root!=null){
            root.left=right;
            root.right=left;
        }
    }

    public static void main(String[] args) {
        MirrorTree mt = new MirrorTree();
//        System.out.println(mt.Mirror(););
    }
}
