package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指offer36 二叉搜索树与双向链表
 */
public class Offer36 {

    Node head;

    List<Node> nodes = new ArrayList<>();

    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        //排序treenode节点
        MidTreverse(root);
        head = nodes.get(0);
        for(int i = 1; i < nodes.size(); i++) {
            nodes.get(i).left = nodes.get(i - 1);
            nodes.get(i - 1).right = nodes.get(i);
        }
        head.left = nodes.get(nodes.size() - 1);
        nodes.get(nodes.size() - 1).right = head;
        return head;
    }

    //中序遍历 左->根->右
    public void MidTreverse(Node root) {
        if(root == null) {
            return;
        }
        MidTreverse(root.left);
        nodes.add(root);
        MidTreverse(root.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };


    public static void main(String[] args) {





    }
}


