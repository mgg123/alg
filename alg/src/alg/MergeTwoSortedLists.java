package alg;

public class MergeTwoSortedLists {
    
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    
    
    /**
     * ���룺1->2->4, 1->3->4
     * �����1->1->2->3->4->4
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode temp = root;      
        //����ͨ�^���^��������ֵ���������С�ֱl1��l2ĳһ���ڵ�ָ����null;
        while (l1 != null && l2 != null) {          
             if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        
        //�ٽ�ʣ�µĲ��䵽�б�β����        
        temp.next = l1 == null ? l2 : l1;
        return root.next;  
    }
    
}
