/**
 * 平衡二叉树左右子树高度差不超过 1。
 */
public class IsBalanced {
    private boolean isBalanced = true;

    public boolean isBlanced(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null || !isBalanced)//确定不是平衡树之后就不用算树的高度了
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;
        return 1 + Math.max(left, right);
    }
}
