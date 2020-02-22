/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Tree2ListNode {
    //先造指针指向空
    private TreeNode pre = null;
    private TreeNode head = null;
    //假设左中右是int[] arr={{3,5,7},{10},{11,13,15}}；

    public TreeNode Convert2(TreeNode root) {
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        node.left = pre;//pre指针一直是左中右移动，可画图理解，涉及到回溯
        if (pre != null)
            pre.right = node;
        pre = node;
        if (head == null)
            head = node;
        inOrder(node.right);
    }

    /**
     * 思考
     * <p>
     * <p>
     * 假设左中右是int[] arr={{3,5,7},{10},{11,13,15}}；
     *
     * @param root
     * @return
     */
    public TreeNode Convert(TreeNode root) {//这个方法整体上实际是中序遍历
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;//从最底层回溯
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        while (p != null && p.right != null) {
            p = p.right;
        }
        if (left != null) {
            p.right = root;
            root.left = p;
        }
        TreeNode right = Convert(root.right);
        if (right != null) {
            root.right = right;
            right.left = root;
        }
        return left != null ? left : root;//该节点得子节点不为空，就把该节点作为左子节点回溯
    }

    public static void main(String[] args) {
    }
}
