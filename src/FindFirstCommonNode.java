/**
 * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
 * 当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；
 * 同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。
 * 这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
 */
public class FindFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode phead1, ListNode phead2) {
        ListNode l1 = phead1, l2 = phead2;
        while (l1 != l2) {//两个指针同时移动，当指针移动到链表尾部时，下一次就移动到另一个链表头部，如果有公共节点就一定会碰头
            l1 = (l1 == null) ? phead2 : l1.next;
            l2 = (l2 == null) ? phead1 : l2.next;
        }
        return l1;
    }
}
