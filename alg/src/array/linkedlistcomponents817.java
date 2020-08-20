package array;

/**
 * 817.链表组件
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
 *
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 *
 *
 * 输入:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * 输出: 2
 * 解释:
 * 链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
 *
 *
 * https://leetcode-cn.com/problems/linked-list-components/
 */
public class linkedlistcomponents817 {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

        //不利用额外空间
        public static int numComponents(ListNode head, int[] G) {
            //返回命中值
            int compentNum = 0;
            //数组G命中计数
            int hitcount = 0;
            //head计数
            int headcount = 0;
            //因为题目要求连续值子集。所以数组G的命中计数与head的命中计数应该是同步增加的。如果head数据与hitCount数据不同,则意味着连续中断。反之连续
            while (head != null) {
                int nodeVal = head.val;
                for(int i = 0; i < G.length; i++) {
                    if(G[i] == nodeVal) {
                        hitcount++;
                        break;
                    }
                }
                //当数组G有命中,链表也同步计数
                if(hitcount > 0) {
                    headcount++;
                }
                //若链表计数大于数组计数且数组计数大于0,则意外这存在组件
                if(headcount > hitcount && hitcount >= 1) {
                    compentNum++;
                    hitcount = 0;
                    headcount = 0;
                }
                head = head.next;
            }
            //遍历完全。存在命中计数未重置为0。则需要把最后的组件补上
            if(hitcount > 0 && head == null) {
                compentNum ++;
            }
          return compentNum;
        }



    public static void main(String[] agrs) {
        ListNode head = new ListNode(0);
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);

        head.next = node;
        node.next = node1;
        node1.next = node2;

        int[] G = new int[]{4};

        System.out.println(numComponents(head,G));

    }

}

