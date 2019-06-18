package newcode;

/**
 * @program: offer
 * @description: 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @author: co1de
 * @create: 2019-06-18 17:03
 **/

public class BTNextNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        //中序，左中右
        TreeLinkNode root = pNode;
        if (root.right != null) {
            //有右子树，下一个节点在右子树的最左边
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
            return root;
        } else {
            //没有右子树，尝试回退到父节点
            while ((root.next != null) && (root != root.next.left)) {
                //如果该节点不是父节点的左子树，回退到父节点
                root = root.next;
            }
            //如果该节点是父节点的左子树，下一个节点就是父节点
            return root.next;
        }
    }
}
