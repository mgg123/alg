package array;

public class reverlinlist24 {

    public volatile ListNode listNode;

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void main(String[] agrs) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        int j,i = 0;
        
        j = i;
        i = 6;
        
        new reverlinlist24().reverseList(a);

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


}


