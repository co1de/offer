package newcode;

/**
 * @program: offer
 * @description: 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * @author: co1de
 * @create: 2019-06-15 20:46
 **/

public class BSTNumK {
    private int ret = 0;
    private TreeNode node = null;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot!=null){
            zhongSearch(pRoot, k);
        }
        return node;
    }

    //中序遍历,左，中，右
    private void zhongSearch(TreeNode root, int k) {
        if (root.left != null) {
            zhongSearch(root.left,k);
        }
        if (++ret == k){
            node = root;
            return;
        }
        if (root.right != null) {
            zhongSearch(root.right,k);
        }
    }
}
