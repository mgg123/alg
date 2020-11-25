package tree;

public class binaryTreeNodeSame_100 {

    public static void main(String[] args) {
        Solution solution = new binaryTreeNodeSame_100().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            //如果当前节点都为NULL 为true;
            if(p == null && q == null) {
                return true;
            }
            //如果当前节点不一致为false
            if((p == null && q != null) || (p != null && q == null) || (p.val != q.val)) {
                return false;
            } else {
                //反之true
                return true & isSameTree(p.left,q.left) & isSameTree(p.right,q.right);
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
    }

    //leetcode submit region end(Prohibit modification and deletion)
}
