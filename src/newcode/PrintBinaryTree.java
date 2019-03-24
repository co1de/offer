package newcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @program: offer
 * @description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author: co1de
 * @create: 2019-03-24 20:13
 **/
public class PrintBinaryTree {
    /** 
    * @Description: 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     * 和打印每行区别不大，只要能区分奇偶行，加入一个数在换行的时候记录即可。
     * @Param:
    * @return:  Z
    * @Author: co1de
    * @Date: 2019/3/24 
    */ 
    public ArrayList<ArrayList<Integer> > PrintZ(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot!=null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(pRoot);
            ArrayList<Integer> eachRow = new ArrayList<>();
            TreeNode temp = null;
            //用一个数来记录后面还有多少个数是同一行的。
            int curLength = 1;
            //该数用来记录下一行需要有多少个数
            int nextLength = 0;
            //当前是第几行
            int curLine = 1;
            while (!queue.isEmpty()) {
                temp = queue.poll();
                //如果为0，说明同一行的数全部存入完毕了，将本行放入返回列表，新起一行
                if (curLength==0){
                    //奇数,正常添加
                    if ((curLine&1) == 1){
                        ret.add(eachRow);
                    }else {
                        //偶数，逆向添加
                        Collections.reverse(eachRow);
                        ret.add(eachRow);
                    }
                    eachRow = new ArrayList<>();
                    curLength=nextLength;
                    nextLength=0;
                    curLine++;
                }
                eachRow.add(temp.val);
                curLength--;

                if (temp.left!=null){
                    queue.add(temp.left);
                    nextLength++;
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    nextLength++;
                }
            }
            //将最后一行加入，容易遗漏。。。
            //奇数,正常添加
            if ((curLine&1) == 1){
                ret.add(eachRow);
            }else {
                //偶数，逆向添加
                Collections.reverse(eachRow);
                ret.add(eachRow);
            }
        }
        return ret;
    }

    /** 
    * @Description:  从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     * 需要区别每一行，用两个数字来记录当前行的数字
     * @Param:
    * @return:  
    * @Author: co1de
    * @Date: 2019/3/24 
    */ 
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot!=null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(pRoot);
            ArrayList<Integer> eachRow = new ArrayList<>();
            TreeNode temp = null;
            //用一个数来记录后面还有多少个数是同一行的。
            int curLength = 1;
            //该数用来记录下一行需要有多少个数
            int nextLength = 0;
            while (!queue.isEmpty()) {
                temp = queue.poll();
                //如果为0，说明同一行的数全部存入完毕了，将本行放入返回列表，新起一行
                if (curLength==0){
                    ret.add(eachRow);
                    eachRow = new ArrayList<>();
                    curLength=nextLength;
                    nextLength=0;
                }
                eachRow.add(temp.val);
                curLength--;

                if (temp.left!=null){
                    queue.add(temp.left);
                    nextLength++;
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    nextLength++;
                }
            }
            //将最后一行加入，容易遗漏。。。
            ret.add(eachRow);
        }
        return ret;
    }
    
    /**
    * @Description: 本地考察层序遍历，利用一个队列，
     * 首节点直接放入队列，然后利用队列维护顺序关系
     * 每次弹出队列首节点加入返回值列表，若该节点有左右孩子，将左右孩子也加入列表，这样就维持了顺序关系
    * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/3/24
    */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root!=null){
            ArrayList<Integer> ret = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode temp = null;
            while (!queue.isEmpty()) {
                temp = queue.poll();
                ret.add(temp.val);
                if (temp.left!=null) queue.add(temp.left);
                if (temp.right!=null) queue.add(temp.right);
            }
            return ret;
        }else {
            //牛客上空要求返回空列表而不是空对象
            return new ArrayList<Integer>();
        }
//        return null;


//        if (root==null) return null;
//        ArrayList<Integer> ret = new ArrayList<>();
//        ArrayList<Integer> left = new ArrayList<>();
//        ArrayList<Integer> right = new ArrayList<>();
//
//        ret.add(root.val);
//        if (root.left!=null) left = PrintFromTopToBottom(root.left);
//        if (root.right!=null) right = PrintFromTopToBottom(root.right);
////        Collections.addAll(left);
////        Collections.addAll(right);
//
//        for (int i = 0; i < left.size(); i++) {
//            ret.add(left.get(i));
//        }
//        for (int i = 0; i < right.size(); i++) {
//            ret.add(right.get(i));
//        }
//        return ret;

    }
}
