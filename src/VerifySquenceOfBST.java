/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    /**
     * 思路
     * 根据二叉树树的特性，左子树所有节点值都小于或等于根节点值，右子树所有节点值都大于根节点值
     * 所以序列中有第一个大于根节点值的数是左右子树的分界点
     *
     * @param sequence
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return verify(sequence, 0, sequence.length - 1);
    }

    public static boolean verify(int[] sequence, int first, int root) {
        if (root - first <= 1) {//如果只有没有子树或者只有一个子树，那么可以肯定是一个该数组是后序遍历的树
            return true;
        }
        int rootval = sequence[root];
        int curIndex = first;
        while (sequence[curIndex] <= rootval && curIndex <= root) {//遍历数组，找到临界值，临界值肯定是右子树的第一值
            curIndex++;
        }
        for (int i = curIndex; i < root; i++) {//从临界值开始往后遍历，如果有小于或等于根节点的值，肯定不是后序遍历的数组
            if (sequence[curIndex] <= rootval) {
                return false;
            }
        }
        return verify(sequence, first, curIndex - 1) && verify(sequence, curIndex, root - 1);
    }
}
