public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode slow = pHead, fast = pHead;
        boolean flag = false;
        while (slow.next != null && slow != null) {//如果没环，必定能走完循环
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {//如果存在环，必定会相遇，这时改变标记，跳出循环
                flag = true;
                break;
            }
        }
        if (flag == false) {//标记没变，说明不存在环
            return null;
        } else {
            fast = pHead;//发现如果让两个指针同时从起点和相遇点开始，每次只走过一个距离，那么最后他们会在环入口节点相遇。
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
}
