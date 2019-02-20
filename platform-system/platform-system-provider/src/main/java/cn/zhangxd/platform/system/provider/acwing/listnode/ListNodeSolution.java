package cn.zhangxd.platform.system.provider.acwing.listnode;

/**
 * @author zhangyongji
 * @since 2019-01-29.
 * refrence url:
 * https://blog.csdn.net/guyuealian/article/details/51119499
 * https://www.cnblogs.com/byrhuangqiang/p/4311336.html
 * https://blog.csdn.net/fx677588/article/details/72357389
 * https://mp.weixin.qq.com/s/H_9C1Fo-OM_J0uQEB1y1YA
 */
public class ListNodeSolution {
    /**
     * 就地翻转法
     * 空间复杂度分析：遍历时只有3个额外变量，所以额外的空间复杂度是 O(1)
     * 时间复杂度分析：只遍历一次链表，时间复杂度是 O(n)
     *
     * @param head
     * @return
     */
    public static ListNode reverseList01(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode cur = head.getNext();
        ListNode temp;
        while (cur != null) {
            temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        head.setNext(null);
        return pre;
    }

    /**
     * 递归反转法：在反转当前节点之前先反转后续节点。这样从头结点开始，层层深入直到尾结点才开始反转指针域的指向。简单的说就是从尾结点开始，逆向反转各个结点的指针域指向，其过程图如下所示：
     * head：是前一结点的指针域（PS：前一结点的指针域指向当前结点）
     * head.getNext()：是当前结点的指针域（PS：当前结点的指针域指向下一结点）
     * newHead：是反转后新链表的头结点（即原来单链表的尾结点）
     *
     * @param head
     * @return
     */
    public static ListNode reverseList02(ListNode head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.getNext() == null) {
            return head;
        }

        ListNode newHead = reverseList02(head.getNext());
        head.getNext()
            .setNext(head);
        head.setNext(null);
        return newHead;
    }

    /**
     * 新建链表，头节点插入法
     *
     * @param head
     * @return
     */
    public static ListNode reverseList03(ListNode head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.getNext() == null) {
            return head;
        }

        ListNode newHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.getNext();
            cur.setNext(newHead);
            newHead = cur;
            cur = temp;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的链表
        ListNode h = head;
        while (null != h) {
            System.out.print(h.getValue() + " ");
            h = h.getNext();
        }
        // 调用反转方法
//        head = reverseList01(head);
//        head = reverseList02(head);
        head = reverseList03(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getValue() + " ");
            head = head.getNext();
        }
    }


}
