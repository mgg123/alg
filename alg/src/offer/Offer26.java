package offer;

/**
 * 树的子结构
 */
public class Offer26 {


    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        //先序遍历
        return A != null && B != null && compare(A,B) && isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public static boolean compare(TreeNode a, TreeNode b) {
        if(a == null) {
            return false;
        }
        if(b == null) {
            return true;
        }
        if(a.val != b.val) {
            return false;
        }
        return compare(a.left,b.left) && compare(a.right,b.right);
    }


     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }


}
