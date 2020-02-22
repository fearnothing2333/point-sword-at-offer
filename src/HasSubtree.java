/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
    /**
     * @param father
     * @param son
     * @return
     */
    public boolean hasSubtree(TreeNode father, TreeNode son) {
        if (father == null || son == null) {
            return false;
        }
        return isSubtreeWithRoot(father, son) || hasSubtree(father.left, son) || hasSubtree(father.right, son);
    }

    /**
     * 当根节点相同时，b树是不是a树的子树
     *
     * @param a
     * @param b
     * @return
     */
    public boolean isSubtreeWithRoot(TreeNode a, TreeNode b) {
        if (b == null) {//遍历到最后左右必为空，说明b树遍历完了
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSubtreeWithRoot(a.left, b.left) || isSubtreeWithRoot(a.right, b.right);
    }
}
