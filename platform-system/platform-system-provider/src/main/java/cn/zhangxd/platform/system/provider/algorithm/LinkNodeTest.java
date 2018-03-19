package cn.zhangxd.platform.system.provider.algorithm;

public class LinkNodeTest {
    public static void main(String[] args) {
        NodeTow head = new NodeTow(0);
        NodeTow node1 = new NodeTow(1);
        NodeTow node2 = new NodeTow(2);
        NodeTow node3 = new NodeTow(3);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的链表
        NodeTow h = head;
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
        // 调用反转方法
        // head = reverse1(head);
        head = reverse2(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }

    /**
     * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
     */
    public static NodeTow reverse2(NodeTow head) {
        if (head == null)
            return head;
        NodeTow pre = head;// 上一结点
        NodeTow cur = head.getNext();// 当前结点
        NodeTow tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur != null) {// 当前结点为null，说明位于尾结点
            tmp = cur.getNext();
            cur.setNext(pre);// 反转指针域的指向

            // 指针往下移动
            pre = cur;
            cur = tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.setNext(null);

        return pre;
    }
}

class NodeTow {
    private int Data;// 数据域
    private NodeTow Next;// 指针域

    public NodeTow(int Data) {
        // super();
        this.Data = Data;
    }

    public int getData() {
        return Data;
    }

    public void setData(int Data) {
        this.Data = Data;
    }

    public NodeTow getNext() {
        return Next;
    }

    public void setNext(NodeTow Next) {
        this.Next = Next;
    }
}