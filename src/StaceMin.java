import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class StaceMin {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));//每次压入的都是当前最小值
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int peek() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
