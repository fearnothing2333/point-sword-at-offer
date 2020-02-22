/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回 。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNext {
    /**
     * 仔细观察，可以把中序下一节点归为几种类型：
     * 1、有右子树，下一节点是右子树中的最左节点，否则就是右子树；
     * 2、无右子树，该节点是其父节点的左子树，则下一节点是该节点的父节点；
     * 3、无右子树，该节点是其父节点的右子树，则我们一直沿着父节点追朔，
     * 直到找到某个节点是其父节点的左子树，如果存在这样的节点，那么这个节点的父节点就是我们要找的下一节点。
     *
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {//如果一个节点的右子树不为空，那么按照中序遍历，该节点的下一个节点是右子树的最左节点；
            TreeLinkNode node = pNode.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else {//无右子树
            while (pNode.next != null) {//next指向父节点；如果父节点存在
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode)//该节点是其父节点的左子树，则下一节点是该节点的父节点
                    return parent;
                pNode = pNode.next;//节点是该节点父节点的右子树，则我们一直沿着父节点追朔，
            }
        }
        return null;
    }
}

