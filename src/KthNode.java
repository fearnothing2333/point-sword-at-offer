import java.util.ArrayList;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * 思路：中序遍历就是从小到大排列了
 */
public class KthNode {

    ArrayList<TreeNode> list = new ArrayList<>();

    TreeNode KthNode(TreeNode pRoot, int k) {
        addNode(pRoot);
        if (k >= 1 && list.size() >= k) {
            return list.get(k - 1);
        }
        return null;
    }

    // 中序遍历的结果就是有序序列，第K个元素就是list[K-1]存储的节点指针；
    void addNode(TreeNode cur) {   // (2)
        if (cur != null) {
            addNode(cur.left);
            list.add(cur);
            addNode(cur.right);
        }
    }
}
