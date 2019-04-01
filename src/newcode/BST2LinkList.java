package newcode;

/**
 * @program: offer
 * @description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author: co1de
 * @create: 2019-04-01 21:34
 **/

public class BST2LinkList {
    private TreeNode preNode = null;
    private TreeNode rootNode = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        reMake(pRootOfTree);
        return rootNode;
    }

    private void reMake(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return;
        }
        if (pRootOfTree.left!=null){
            reMake(pRootOfTree.left);
        }
        //先从左边递归，到这是左边最深的叶子节点，即首节点。
        if (rootNode==null) rootNode = pRootOfTree;
        if (preNode == null){
            preNode = pRootOfTree;
        }else {
            preNode.right = pRootOfTree;
            pRootOfTree.left = preNode;
            preNode = pRootOfTree;
        }

        if (pRootOfTree.right!=null){
            reMake(pRootOfTree.right);
        }
    }
}
