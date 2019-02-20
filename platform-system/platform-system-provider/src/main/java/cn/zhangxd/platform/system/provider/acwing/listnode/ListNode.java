package cn.zhangxd.platform.system.provider.acwing.listnode;

/**
 * @author zhangyongji
 * @since 2019-01-29.
 */
public class ListNode {
    private int value;
    private ListNode next;

    ListNode(int data) {
        value = data;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
