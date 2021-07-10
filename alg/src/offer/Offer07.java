package offer;

import java.util.HashMap;

/**
 * 重建2叉树
 */
public class Offer07 {

    static int[] preorders;//保留的先序遍历
    static HashMap<Integer,Integer> inorderMap = new HashMap<>();
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        preorders = preorder;
        for (int i = 0; i < preorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return recursive(0,0,inorder.length - 1);
    }

    //递归方式

    /**
     *
     * @param rootindex 前序遍历的根索引
     * @param leftindex  中序遍历的左子树边界索引
     * @param rightindex 中序遍历的右子树边界索引
     * @return
     */
    private static TreeNode recursive(int rootindex, int leftindex, int rightindex) {

        if(leftindex > rightindex) {
            return null;
        }

        TreeNode root = new TreeNode(preorders[rootindex]);
        //中序遍历中的root根索引
        int idx = inorderMap.get(preorders[rootindex]);

        root.left = recursive(rootindex + 1,leftindex,idx - 1);

        //右子树根节点索引= 根索引+左子树数量，  左子树数量 可以根据 中序遍历的索引位置计算出。 idx为中序遍历的根索引地址，leftindex为中序遍历的左子树边界索引。
        root.right = recursive(rootindex + (idx - leftindex) + 1,idx + 1, rightindex);

        return root;
    }


    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

}
