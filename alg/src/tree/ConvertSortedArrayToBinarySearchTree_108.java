package tree;

//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:                2
//              0   1     3     6
// 给定有序数组: [-10,-3,0,5,9,10,11],
//                        5
//                         / \
//         0,  2 3 4   6  -3  10
//            1       5   / \ /  \
//                      -10 0 9  11
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0                 5
//     / \               / \
//   -3   9             -3   9
//                      / \  / \

//   /   /
// -10  5
//

// Related Topics 树 深度优先搜索
public class ConvertSortedArrayToBinarySearchTree_108 {

    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree_108().new Solution();
        int[] nums = new int[]{-10,-3,0,5,9,10};
        TreeNode treeNode = solution.sortedArrayToBST(nums);

        System.out.println(treeNode);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return sort(0,nums.length -1,nums);
        }

        private TreeNode sort(int l, int r, int[] nums) {
            if(l > r) {
                return null;
            }
            int mid = (l + r) / 2;
            TreeNode no = new TreeNode(nums[mid]);
            no.left = sort(l,mid-1,nums);
            no.right = sort(mid+1,r,nums);
            return no;
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
