package testMethod;

import com.nixuan.util.TreeNode;

public class testTreeNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftNode = new TreeNode(2);
        root.leftNode.leftNode = new TreeNode(4);
        root.leftNode.leftNode.rightNode = new TreeNode(6);

        root.rightNode = new TreeNode(3);
        root.rightNode.leftNode = new TreeNode(5);

        TreeNode.preTravesal(root);
        TreeNode.inTravesal(root);
        TreeNode.postTravesal(root);
    }

}
