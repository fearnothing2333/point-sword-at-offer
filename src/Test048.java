import java.util.ArrayList;
import java.util.Stack;

/**
 * 获取最长子字符串：输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 */

public class Test048 {

    /**
     * 从尾到头打印链表方法01
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead01(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead01(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    /**
     * 从尾到头打印链表方法02
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead02(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ins = new ArrayList<>();
        while (!stack.isEmpty()) {
            ins.add(stack.pop());
        }
        return ins;
    }
}
