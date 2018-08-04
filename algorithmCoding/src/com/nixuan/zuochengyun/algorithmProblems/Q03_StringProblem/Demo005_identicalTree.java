package com.nixuan.zuochengyun.algorithmProblems.Q03_StringProblem;

import com.nixuan.util.TreeNode;
/**
*对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。*
* 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 *
 * 这个问题最好的解法是现将两颗树序列化，在使用KMP算法看序列化之后的字符串是否存在包含关系
 * 不会KMP所以使用的是通过后续遍历去匹配
 *
 * 这个题说的是子树，1     与   1，这个是false，因为1不是前一个树的子树，注意题目要求
 *                / \
 *               2   3
*/
public class Demo005_identicalTree {

    public boolean chkIdentical(TreeNode A, TreeNode B) {
        // write code here
        boolean res = hasSubtree(A,B);

        if(!res&&A!=null){
            res = chkIdentical(A.leftNode,B);
        }
        if(!res&&A!=null){
            res = chkIdentical(A.rightNode,B);
        }
        return res;
    }

    private boolean hasSubtree(TreeNode a, TreeNode b) {
        if(a == null && b == null){
            return true;
        }
        if(a == null || b == null){
            return false;
        }
        if(!a.val.equals(b.val)){
            return false;
        }
        return hasSubtree(a.leftNode,b.leftNode)&&hasSubtree(a.rightNode,b.rightNode);
    }
}
