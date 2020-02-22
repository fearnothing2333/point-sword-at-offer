public class LowestCommonAncestor {
    public TreeNode build(int[] arr, int n) {
        if (n < arr.length) {
            TreeNode t = new TreeNode(arr[n]);
            t.left = build(arr, 2 * n + 1);
            t.right = build(arr, 2 * n + 2);
            return t;
        }
        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root.left.val == -1) {
            root.left = null;
        }
        if (root.right.val == -1) {
            root.right = null;
        }
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public void change(TreeNode t) {
        if (t.val == -1) {
        }
    }

    /**
     * 顺序数组二叉搜索树的公共祖先
     *
     * @param arr 数组
     * @param n   头节点值
     * @param p   节点
     * @param q   节点
     * @return
     */
    public int lowestCommonAncestorForArray(int[] arr, int n, int p, int q) {
        if (isLegal(arr, p, q)) {
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
        } else return -1;
    }

    public boolean isLegal(int[] arr, int p, int q) {
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

    /**
     * 顺序数组普通二叉树的最低公共祖先
     *
     * @param arr
     * @param n
     * @param p
     * @param q
     * @return
     */
    public int lowestCommonAncestor(int[] arr, int n, int p, int q) {
        if (n >= arr.length) {
            return -1;
        }
        if (arr[n] == -1 || arr[n] == p || arr[n] == q)
            return arr[n];
        int left = lowestCommonAncestor(arr, 2 * n + 1, p, q);
        int right = lowestCommonAncestor(arr, 2 * n + 2, p, q);
        return left == -1 ? right : right == -1 ? left : arr[n];
    }

    public static void main(String[] args) {
        LowestCommonAncestor build = new LowestCommonAncestor();
        int[] arr = {9, 6, 15, 2, -1, 12, 25, -1, -1, -1, -1, -1, -1, 20, 37};
        int t = build.lowestCommonAncestorForArray(arr, 0, 12, 20);
        System.out.println(t);
    }
}
