import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //若数组为空，则返回null值；
        if (pre == null || in == null) {
            return null;
        }
        //创建辅助map；
        HashMap<Integer, Integer> intmap = new HashMap<>();
        //将中序数组存入map,数组元素值为键，数组下标为值
        for (int i = 0; i < in.length; i++) {
            intmap.put(in[i], i);
        }
        return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, intmap);
    }

    /**
     * @param pre    前序数组
     * @param preL   前序数组左下标
     * @param preR   前序数组右下标
     * @param in     中序数组
     * @param inL    中序数组左下标
     * @param inR    中序数组右下标
     * @param intmap 辅助集合
     * @return
     */
    public TreeNode preIn(int[] pre, int preL, int preR, int[] in, int inL, int inR, HashMap<Integer, Integer> intmap) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inRootIndex = intmap.get(root.val);
        int leftTreeSize = inRootIndex - inL;
        root.left = preIn(pre, preL + 1, preL + leftTreeSize, in, inL, inRootIndex - 1, intmap);
        root.right = preIn(pre, preL + leftTreeSize + 1, preR, in, inRootIndex + 1, inR, intmap);
        return root;
    }
}






