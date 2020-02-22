import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 思路：使用队列来进行层次遍历。
 * 不需要使用两个队列分别存储当前层的节点和下一层的节点，
 * 因为在开始遍历一层的节点时，当前队列中的节点数就是当前层的节点数，
 * 只要控制遍历这么多节点数，就能保证这次遍历的都是当前层的节点。
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);//先把根节点加入队列
        while (!queue.isEmpty()) {//如果队列不为空
            int cnt = queue.size();//取队列的长度
            while (cnt-- > 0) {//队列有多长，就循环多少次，当前队列中的节点数就是当前层的节点数
                TreeNode t = queue.poll();//删除并返回队头，先进先出
                list.add(t.val);
                queue.add(t.left);//
                queue.add(t.right);
            }
        }
        return list;
    }
}
