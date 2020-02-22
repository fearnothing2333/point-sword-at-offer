/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 解题思路
 * 设链表的长度为 N。设置两个指针 P 和 Q，都在最左边，先让 P1移动 K 个节点，
 * 则还有 N - K 个节点可以移动。此时让 p 和 q 同时移动，
 * 可以知道当 p 移动到链表结尾时，q移动到第 N - K 个节点处，
 * 该位置就是倒数第 K 个节点。
 */
public class FindKthToTail {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode p = head;
        while (p != null && k-- > 0) {
            p = p.next;
        }
        if (k > 0) {//如果ListNode都遍历完了，K的值扔大于0，则k的长度超过整个ListNode的长度，返回null值；
            return null;
        }
        ListNode q = head;
        while (p != null) {//此时还剩N-K个节点，顺着数N-K个节点，该位置就是倒数第K个节点；
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
