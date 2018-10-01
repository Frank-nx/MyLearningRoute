package testMethod;

import com.nixuan.util.TreeNode;

import java.util.*;

/**
 * @program: MyLearningRoute
 * @description: 树的遍历
 * @author: nixuan
 * @create: 2018-09-17 22:27
 **/
public class treeTest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftNode = new TreeNode(2);
        root.leftNode.leftNode = new TreeNode(4);
        root.leftNode.leftNode.rightNode = new TreeNode(6);

        root.rightNode = new TreeNode(3);
        root.rightNode.leftNode = new TreeNode(5);
        root.rightNode.rightNode = new TreeNode(7);

        //travelByLevel(root);
        //preTravel(root);
        //inTravel(root);
        //postTravel(root);
        //inTravel1(root);
        /*String s = serialTree(root);
        System.out.println(s);
        TreeNode root2 = reserialTree(s);
        preTravel(root2);*/
        //paperfolder(3);
        System.out.println(longestDistance(root));
    }

    public static void travelByLevel(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode last = root;
        TreeNode nlast = root;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(cur.val + ",");
            if(cur.leftNode != null){
                nlast = cur.leftNode;
                queue.add(nlast);
            }
            if(cur.rightNode != null){
                nlast = cur.rightNode;
                queue.add(nlast);
            }
            if(last == cur){
                last = nlast;
                System.out.println();
            }
        }
    }

    public static void preTravel(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            System.out.print(cur.val + ",");
            if(cur.rightNode != null){
                stack.push(cur.rightNode);
            }
            if(cur.leftNode != null){
                stack.push(cur.leftNode);
            }
        }
        System.out.println();
    }

    public static void inTravel1(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.leftNode;
            }else{
                root = stack.pop();
                System.out.print(root.val + ",");
                root = root.rightNode;
            }
        }
        System.out.println();
    }

    public static void inTravel(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        //stack.push(root);
        TreeNode cur = root;

        while(true){
            while(cur != null){
                stack.push(cur);
                cur = cur.leftNode;
            }
            if(stack.isEmpty()){
                break;
            }
            cur = stack.pop();
            System.out.print(cur.val + ",");

            cur = cur.rightNode;
        }
        System.out.println();
    }

    public static void postTravel(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> help = new Stack<>();

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            help.push(cur);
            if(cur.leftNode != null){
                stack.push(cur.leftNode);
            }
            if(cur.rightNode != null){
                stack.push(cur.rightNode);
            }
        }
        while(!help.isEmpty()){
            System.out.print(help.pop().val + ",");
        }
    }

    public static String serialTree(TreeNode root){
        if(root == null){
            return "#!";
        }
        StringBuilder sb = new StringBuilder(root.val + "!");
        sb.append(serialTree(root.leftNode));
        sb.append(serialTree(root.rightNode));
        return sb.toString();
    }

    public static TreeNode reserialTree(String s){
        if(s == null){
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        String[] arr = s.split("!");
        for(int i = 0;i<arr.length;i++){
            queue.add(arr[i]);
        }
        return buildTree(queue);
    }

    private static TreeNode buildTree(Queue<String> queue) {
        if(!queue.isEmpty()){
            String s = queue.poll();
            if("#".equals(s)){
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(s));
            root.leftNode = buildTree(queue);
            root.rightNode = buildTree(queue);
            return root;
        }
        return null;
    }

    public static boolean isBalance(TreeNode root){
        if(root == null){
            return true;
        }
        ReturnDate res = judgeBalance(root);
        return res.isB;
    }

    private static ReturnDate judgeBalance(TreeNode root) {
        if(root == null){
            return new ReturnDate(true,0);
        }
        ReturnDate left = judgeBalance(root.leftNode);
        if(!left.isB){
            return new ReturnDate(false,0);
        }
        ReturnDate right = judgeBalance(root.rightNode);
        if(!right.isB){
            return new ReturnDate(false,0);
        }
        if(Math.abs(left.depth-right.depth) > 1){
            return new ReturnDate(false,0);
        }else{
            return new ReturnDate(true,Math.max(left.depth,right.depth)+1);
        }

    }

    private static class ReturnDate{
        private int depth;
        private boolean isB;

        public ReturnDate(boolean isB,int depth){
            this.depth = depth;
            this.isB = isB;
        }
    }

    public static boolean isBalance1(TreeNode root){
        if(root == null){
            return true;
        }
        return getDepth(root,1)!=-1;
    }

    private static int getDepth(TreeNode root, int depth) {
        if(root == null){
            return depth;
        }
        int left = getDepth(root.leftNode,depth);
        if(left == -1){
            return -1;
        }
        int right = getDepth(root.rightNode,depth);
        if(right == -1){
            return -1;
        }
        if(Math.abs(left-right) > 1){
            return -1;
        }
        return Math.max(left,right)+1;
    }

    public static boolean completeTree(TreeNode root){
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeaf = false;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.leftNode != null && cur.rightNode != null){
                if(isLeaf){
                    return false;
                }
                queue.add(cur.leftNode);
                queue.add(cur.rightNode);
            }else if (cur.leftNode != null){
                if(isLeaf){
                    return false;
                }
                queue.add(cur.leftNode);
                isLeaf = true;
            }else if(cur.rightNode != null){
                return false;
            }else{
                isLeaf = true;
            }
        }
        return true;
    }

    public static void paperfolder(int n){
        if(n < 1){
            return;
        }
        paperfolder(n,true);
    }

    private static void paperfolder(int n, boolean flag) {
        if(n <= 0){
            return;
        }

        paperfolder(n-1,true);
        if(flag){
            System.out.print("down,");
        }else{
            System.out.print("up,");
        }
        paperfolder(n-1,false);
    }

    public static int[] findErrorNums(TreeNode root){
        if(root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] res = new int[]{-1,-1};
        inT(root,list);
        for(int i = 0;i<list.size()-1;i++){
            if(list.get(i) > list.get(i+1)){
                res[1] = res[1] == -1?list.get(i):res[1];
                res[0] = list.get(i+1);
            }
        }
        return res;
    }

    private static void inT(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        inT(root.leftNode,list);
        list.add(root.val);
        inT(root.rightNode,list);
    }

    public static int longestDistance(TreeNode root){
        if(root == null){
            return 0;
        }
        int[] res = new int[1];
        depth(root,res);
        return res[0];
    }

    public static int depth(TreeNode root,int[] res){
        if(root == null){
            return 0;
        }
        int left = depth(root.leftNode,res);
        int right = depth(root.rightNode,res);
        int num = left+right+1;
        res[0] = num > res[0]?num:res[0];
        return Math.max(left,right)+1;
    }
}
