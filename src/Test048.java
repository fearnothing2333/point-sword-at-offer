import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * 获取最长子字符串：输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 */

public class Test048 {
    public int getMaxSubstringWithoutDuplication(String s) {
        //定义初始返回值
        int res = 0;
        if (s.length() == 0) {
            return res;
        }
        //定义一个map用于存放并更新出现过的字符位置
        HashMap<Character, Integer> map = new HashMap<>();
        //定义左指针和右指针，双指针遍历字符串
        for (int left = 0, right = 0; right < s.length(); right++) {
            //判断右指针是否扫描过该字符
            if (map.containsKey(s.charAt(right))) {
                //如果出现过便将左指针所在下标更改
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            //存放并更新出现过的字符位置
            map.put(s.charAt(right), right);
            //存放最大的子字符串长度
            res = Math.max(res, (right - left) + 1);
        }
        return res;
    }

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
