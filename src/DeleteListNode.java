/**
 * 在 O(1) 时间内删除链表节点
 */
public class DeleteListNode {
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null)//安全检验
            return null;
        if (tobeDelete.next != null) {
            // 要删除的节点不是尾节点
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        } else {
            if (head == tobeDelete)
                // 只有一个节点，要考虑到这种情况
                head = null;
            else {
                ListNode cur = head;
                while (cur.next != tobeDelete)
                    cur = cur.next;
                cur.next = null;
            }
        }
        return head;
    }
}
