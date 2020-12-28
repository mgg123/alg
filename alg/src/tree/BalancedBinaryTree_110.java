package tree;

//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：true
//
//
// 示例 2：
//
//
//                        1
//                       / \
//                      2   2
//                     / \
//                    3   3
//                   / \
//                  4   4
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//
//
// 示例 3：
//
//
//输入：root = []
//输出：true
//
//
//
//
// 提示：
//
//
// 树中的节点数在范围 [0, 5000] 内
// -104 <= Node.val <= 104
//
// Related Topics 树 深度优先搜索 递归
// 👍 543 👎 0
public class BalancedBinaryTree_110 {

    public static void main(String[] args) {
        BalancedBinaryTree_110.Solution solution = new Solution();
        //输入：root = [1,2,2,3,3,null,null,4,4]

        Solution.TreeNode node = new Solution.TreeNode(1);
            Solution.TreeNode node1 = new Solution.TreeNode(2);
                Solution.TreeNode node11 = new Solution.TreeNode(3);
                    Solution.TreeNode node111 = new Solution.TreeNode(4);
                    Solution.TreeNode node112 = new Solution.TreeNode(4);
                Solution.TreeNode node12 = new Solution.TreeNode(3);
            Solution.TreeNode node2 = new Solution.TreeNode(2);

            node.left = node1;
            node.right = node2;

        node1.left = node11;
        node1.right = node12;

        node11.left = node111;
        node11.right = node112;


        System.out.println(solution.isBalanced(node));

    }

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if(root == null) {
                return true;
            } else {
                return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
            }

        }
        public int height(TreeNode node) {
            if(node == null) {
                return 0;
            }
            return Math.max(height(node.left),height(node.right)) + 1;
        }

        public boolean isBalancedV2(TreeNode root) {
           return heightV2(root) != -1;
        }

        /**
         * 后序遍历
         * @param root
         * @returnd
         */
        public int heightV2(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int leftheigh = heightV2(root.left);
            int rightheigh = heightV2(root.right);
            if(leftheigh == -1 || rightheigh == -1 || Math.abs(leftheigh - rightheigh) > 1) {
                return -1;
            } else {
                return Math.max(leftheigh,rightheigh) + 1;
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
        }

    }
}



//leetcode submit region end(Prohibit modification and deletion)

