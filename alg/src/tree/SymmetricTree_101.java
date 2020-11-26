package tree;

/**
 * 对称二叉树
 */
public class SymmetricTree_101 {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree_101().new Solution();

        TreeNode root = new SymmetricTree_101().new TreeNode(10);

        TreeNode left = new SymmetricTree_101().new TreeNode(11);
            TreeNode left1 = new SymmetricTree_101().new TreeNode(2);
                TreeNode left1_l = new SymmetricTree_101().new TreeNode(3);
                TreeNode left1_r = new SymmetricTree_101().new TreeNode(4);
            TreeNode right1 = new SymmetricTree_101().new TreeNode(3);
                TreeNode right_l = new SymmetricTree_101().new TreeNode(7);
                TreeNode right_r = new SymmetricTree_101().new TreeNode(8);

        TreeNode right = new SymmetricTree_101().new TreeNode(11);
            TreeNode left2 = new SymmetricTree_101().new TreeNode(3);
                TreeNode left2_l = new SymmetricTree_101().new TreeNode(8);
                TreeNode left2_r = new SymmetricTree_101().new TreeNode(7);
            TreeNode right2 = new SymmetricTree_101().new TreeNode(2);
                TreeNode right2_l = new SymmetricTree_101().new TreeNode(4);
                TreeNode right2_r = new SymmetricTree_101().new TreeNode(3);

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

        System.out.println(solution.isSymmetric(root));
    }



    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return isSymmetricPlus(root,root);
        }

        public boolean isSymmetricPlus(TreeNode left,TreeNode right) {
            if(left == null && right == null) {
                return true;
            }
            if((left != null && right == null) || (left == null && right != null) || left.val != right.val) {
                return false;
            }
            return true & isSymmetricPlus(left.left,right.right) & isSymmetricPlus(left.right,right.left);
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
