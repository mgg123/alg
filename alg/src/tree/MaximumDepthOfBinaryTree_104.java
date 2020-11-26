package tree;

public class MaximumDepthOfBinaryTree_104 {

    public static void main(String[] agrs) {

    }

    class Solution {
        public int maxDepth(TreeNode root) {
            return maxDepthPlus(root,0);
        }

        public int maxDepthPlus(TreeNode node, int i) {
            if(node == null) {
                return i;
            } else {
                return Math.max(maxDepthPlus(node.getLeft(),i+1),maxDepthPlus(node.getRight(),i+1));
            }
        }
    }


    public class TreeNode {
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
