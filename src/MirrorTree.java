/**
 * 将二叉树反转
 */
public class MirrorTree {
    public void mirrorTree(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root);//将左子节点与右子节点交换
        mirrorTree(root.right);//递归，传入左子节点
        mirrorTree(root.left);//递归，传入右子节点
    }

    private void swap(TreeNode t) {
        TreeNode temp = t.left;
        t.left = t.right;
        t.right = temp;
    }
}
