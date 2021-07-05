package tree;

//2叉树遍历
public class BinaryTreeTraverse {

     class TreeNode  {
        TreeNode left;
        TreeNode right;
     }

    //前序遍历 根->左->右
    public void QianTreverse(TreeNode root,int level) {
        if(root == null) {
            return ;
        }
        System.out.println(root.toString() + level);
        QianTreverse(root.left,level + 1);
        QianTreverse(root.right,level + 1);
    }

    //中序遍历 左->根->右
    public void MidTreverse(TreeNode root,int level) {
        if(root == null) {
            return ;
        }
        MidTreverse(root.left,level + 1);
        System.out.println(root.toString() + level);
        MidTreverse(root.right,level + 1);
    }


    //后续遍历 ->左->右->根
    public void behindTreverse(TreeNode root, int level) {
        if(root == null) {
            return ;
        }
        MidTreverse(root.left,level + 1);
        MidTreverse(root.right,level + 1);
        System.out.println(root.toString() + level);
    }


}
