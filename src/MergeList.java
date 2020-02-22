/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeList {
    public ListNode merge(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.val <= b.val) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return a;
        }
    }

    /**
     * 没看明白
     *
     * @param a
     * @param b
     * @return
     */
    public static ListNode merge2(ListNode a, ListNode b) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (a != null || b != null) { //砍头法
            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if (a != null)
            cur.next = a;
        if (b != null)
            cur.next = b;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        a1.next = a2;
        ListNode a3 = new ListNode(5);
        a2.next = a3;
        ListNode a4 = new ListNode(7);
        a3.next = a4;
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(4);
        b1.next = b2;
        ListNode b3 = new ListNode(6);
        b2.next = b3;
        ListNode b4 = new ListNode(8);
        b3.next = b4;
        ListNode node = merge2(a1, b1);
    }
}
