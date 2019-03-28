package newcode;

import java.util.ArrayList;

/**
 * @program: offer
 * @description: 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * @author: co1de
 * @create: 2019-03-28 20:58
 **/

public class FindSumPathInBST {
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        findMyPath(root,target,new ArrayList<>());
        return ret;
    }

    /** 
    * @Description: 利用先序遍历，这里困扰我的是这个结构怎么存，脑子不转了。。利用成员变量即可内部访问了。。
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/3/28 
    */ 
    private void findMyPath(TreeNode root, int target, ArrayList<Integer> path) {
        if (root==null) return;
        path.add(root.val);
        target=target-root.val;
        //到叶子节点且为目标值了，可以将当前路径添加到路径集合中
        if (target == 0 && root.left == null && root.right == null) {
            //这里要new，否则传的是一个对象，需要注意
            ret.add(new ArrayList<>(path));
        } else {
            findMyPath(root.left,target,path);
            findMyPath(root.right,target,path);
        }
        //需要回退一步删除路径
        path.remove(path.size() - 1);
    }
}
