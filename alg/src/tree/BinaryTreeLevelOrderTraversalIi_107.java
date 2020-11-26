package tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversalIi_107 {


    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi_107().new Solution();

        TreeNode root = new TreeNode(10);
        TreeNode root_1 = new TreeNode(10);

        TreeNode left = new TreeNode(11);
        TreeNode left1 = new TreeNode(2);
        TreeNode left1_l = new TreeNode(3);
        TreeNode left1_r = new TreeNode(4);
        TreeNode right1 = new TreeNode(3);
        TreeNode right_l = new TreeNode(7);
        TreeNode right_r = new TreeNode(8);

        TreeNode right = new TreeNode(11);
        TreeNode left2 = new TreeNode(3);
        TreeNode left2_l = new TreeNode(8);
        TreeNode left2_r = new TreeNode(7);
        TreeNode right2 = new TreeNode(2);
        TreeNode right2_l = new TreeNode(4);
        TreeNode right2_r = new TreeNode(3);

//                 10
//              11 ,  11
//            2,  3,  3,  2
//           3,4 7,8 8,7,4,3
        root.setLeft(left);
        root.setRight(right);

        left.setLeft(left1);
        left1.setLeft(left1_l);
        left1.setRight(left1_r);

        left.setRight(right1);
        right1.setLeft(right_l);
        right1.setRight(right_r);

        right.setLeft(left2);
        left2.setLeft(left2_l);
        left2.setRight(left2_r);

        right.setRight(right2);
        right2.setLeft(right2_l);
        right2.setRight(right2_r);

        solution.levelOrderBottom(root_1);
    }


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root == null) {
                return  result;
            }
            ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
            //暂存每一层node;
            ArrayDeque<TreeNode> tempqueue = new ArrayDeque<TreeNode>();
            queue.offer(root);
            List<Integer> temp = new ArrayList<>();
            while (!queue.isEmpty() || !tempqueue.isEmpty()) {
                TreeNode node = queue.poll();
                //如果当前层级读完，进行一系列的操作赋值
                if(node == null) {
                    result.add(temp);
                    temp = new ArrayList<>();
                    queue.addAll(tempqueue);
                    tempqueue.clear();
                    node = queue.poll();
                }

                if(node.left != null) {
                    tempqueue.offer(node.left);
                }
                if(node.right != null) {
                    tempqueue.offer(node.right);
                }
                //添加每一层级node的值
                temp.add(node.val);
            }
            if(!temp.isEmpty()) {
                result.add(temp);
            }
            Collections.reverse(result);
            return result;
        }
    }

    /**
     * 代码优化版，逻辑不变遍历每一层
     */
    class Solution2 {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            if(root == null) {
                return  result;
            }
            ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> temp = new ArrayList<>();
                for(int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                    temp.add(node.val);
                }
                result.add(0,temp);
            }
            return result;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode setLeft(TreeNode left) {
            this.left = left;
            return this;
        }

        public TreeNode getRight() {
            return right;
        }

        public TreeNode setRight(TreeNode right) {
            this.right = right;
            return this;
        }
    }

}
