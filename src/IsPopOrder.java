import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
 */
public class IsPopOrder {
    public boolean isPopOrder(int[] push, int[] pop) {
        if (pop.length != push.length) {
            return false;
        }
        int n = push.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {//每次压入一个值就与序列比较
            stack.push(push[popIndex]);
            while (popIndex < n && !stack.isEmpty() && stack.peek() == pop[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
