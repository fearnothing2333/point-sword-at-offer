/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    /**
     * 递归法
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {//当该链表没有子链时候，返回该链表
            return head;
        }
        ListNode next = head.next;//将该链表的子链拿出来 假设是倒数第二次递归headval=8,headnext=9
        head.next = null;//并将原来的子链置空 headval=8 headnext = null
        ListNode newHead = reverseList(next);//将子链作为新链递归上述步骤 newHeadval=9
        next.next = head;//将没有子链的原链附给子链做尾链 nextval=9,headnext=8, 此时指针指向newHead
        return newHead;
    }

    /**
     * 头插法
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode newlist = new ListNode(-1);//新建一个链表
        while (head != null) {
            ListNode next = head.next;//浅拷贝一个子节点
            head.next = newlist.next;//新节点的子节点替换掉原来子节点
            newlist.next = head;//等于链表从头到尾一个一个插到新链表中
            head = next;
        }
        return newlist.next;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode head = new ListNode(0);
        for (int i = 1; i < 10; i++) {
            head.add(i);
        }
        System.out.println(head);
        ListNode newhead = reverseList(head);
        System.out.println(newhead);
    }
}
