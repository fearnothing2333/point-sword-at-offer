/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。前序版
 */
public class SerializeTree {
    private String deserializeStr;//成员变量

    public String Serialize(TreeNode root) {
        if (root == null)
            return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    public TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    private TreeNode Deserialize() {
        if (deserializeStr.length() == 0)
            return null;
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);//左闭右开，所以得到的是头结点
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);//删掉头结点
        if (node.equals("#"))
            return null;
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }
}
