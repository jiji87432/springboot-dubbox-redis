package cn.zhangxd.platform.system.provider.acwing;


class Solution {
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode root = new ListNode(0);
        ListNode cur = root;
        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null ? l1 : l2);
        return cur.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode l1 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        l1.next = node1;
        node1.next = node2;
        ListNode l2 = null;
        head = merge(l1, l2);
        printList(head);
    }
}