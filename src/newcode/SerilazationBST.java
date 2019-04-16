package newcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: offer
 * @description: 请实现两个函数，分别用来序列化和反序列化二叉树
 * @author: co1de
 * @create: 2019-04-10 21:15
 **/

public class SerilazationBST {
    private static String[] dstr;
    private static LinkedList<String> dd = new LinkedList<>();
    private static String Serialize(TreeNode root) {
        //前序构建
        if (root==null) return "#";
        return root.val+" "+Serialize(root.left)+" "+Serialize(root.right);

    }
    private static TreeNode Deserialize(String str) {
        dstr = str.split(" ");
        for (String s:dstr){
            dd.add(s);
        }
        return Deserialize();
    }

    /** 
    * @Description: 按中左右的方式解析即可 
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/4/16 
    */ 
    private static TreeNode Deserialize() {
        if (dd.size()==0) return null;
        String nodeval = dd.poll();
        if (nodeval.equals("#")) return null;
        int val = Integer.valueOf(nodeval);
        TreeNode node = new TreeNode(val);
        node.left = Deserialize();
        node.right = Deserialize();
        return node;
    }

    public static void main(String[] args) {
        String s = "1 2 4 # # # 3 5 # # 6 # #";
        TreeNode n = Deserialize(s);
        System.out.println(Serialize(n));
    }
}
