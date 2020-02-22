package listnode;

import common.RandomListNode;

/**
 * 复制一个复杂节点
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的 head。
 */
public class RandomListNodeClone {
    /**
     * 一、在每个节点插入克隆节点
     * 二、给克隆节点建立连接
     * 三、挨个子节点，子节点为下下个节点
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        // 插入克隆节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // 建立 random 链接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null)
                clone.random = cur.random.next;
            cur = clone.next;
        }
        //恢复原链表
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {//指针所在节点的子节点不为空，即该节点有克隆节点
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }
}
//class RandomListNode {
//    int label;
//    RandomListNode next = null;
//    RandomListNode random = null;
//
//    RandomListNode(int label) {
//        this.label = label;
//    }
//}

