package treenode;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值得路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class TreeRoute {
    private ArrayList<ArrayList<Integer>> lists = new ArrayList<>();//路径集合

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        return lists;
    }

    private void backtracking(TreeNode node, int taget, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        taget -= node.val;
        if (taget == 0 && node.left == null && node.right == null) {//当目标值刚好为零且为叶节点值时，说明路径找到
            lists.add(new ArrayList<>(list));
        } else {
            backtracking(node.left, taget, list);
            backtracking(node.right, taget, list);
        }
        list.remove(list.size() - 1);//回退，必须理解递归的过程和本质；无论有没有找到list的值都必须返回到上一步
    }
}
