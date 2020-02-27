package qi_an_xin;

/**
 * 顺序数组二叉搜索树的公共祖先
 * 输入
 * 二元查找树（1.若左子树不空，左子树值都小于父节点；2.如右子树不空，右子树值都大于父节点；3.左、右子树都是二元查找树；4. 没有键值相等的节点）上任意两个节点的值，请找出它们最近的公共祖先。
 * 输入三行行，第一行为树层级，第二行为数节点（其中-1表示为空节点），第三行为需要查找祖先的两个数。
 * 在例图中（虚线框没有真实节点，为了输入方便对应位置输-1）查找12和20的最近公共祖先输入为：
 * 4
 * 9 6 15 2 -1 12 25 -1 -1 -1 -1 -1 -1 20 37
 * 12 20
 * 输出给出两个数在树上的最近公共祖先数值，如果没有公共祖先，输出-1；如果其中一个节点是另一个节点的祖先，输出这个祖先点（如例图中找15、20最近公共祖先，输出15）；如果输入无效，输出-1。
 * 样例输入
 * 4
 * 9 6 15 2 -1 12 25 -1 -1 -1 -1 -1 -1 20 37
 * 12 20
 * 样例输出
 * 15
 */
public class LongestCommonAncestor {
    /**
     * 顺序数组二叉搜索树的公共祖先
     *
     * @param arr 数组
     * @param n   头节点值所在位置
     * @param p   节点
     * @param q   节点
     * @return
     */
    public int lowestCommonAncestorForArray(int[] arr, int n, int p, int q) {
        if (arr[n] == -1 || n >= arr.length) {
            return -1;
        }
        if (arr[n] > p && arr[n] > q) {
            return lowestCommonAncestorForArray(arr, 2 * n + 1, p, q);
        }
        if (arr[n] < p && arr[n] < q) {
            return lowestCommonAncestorForArray(arr, 2 * n + 2, p, q);
        }
        return arr[n];
    }

    /**
     * 验证节点值是否在数组中
     *
     * @param arr
     * @param p
     * @param q
     * @return
     */
    private boolean isLegal(int[] arr, int p, int q) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == p) {
                cnt++;
            }
            if (arr[i] == q) {
                cnt++;
            }
        }
        return cnt > 1;
    }
}
