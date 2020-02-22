public class ListNode {
    //为方便使用，变量使用public
    public int val;   //存放数据的变量
    public ListNode next;   //存放结点的变量，默认为null

    public ListNode() {
    }    //无参构造方法

    public ListNode(int val) {
        this.val = val;
    }

    //添加结点
    public void add(int val) {
        ListNode newNode = new ListNode(val);    //创建一个结点
        if (this.next == null) {
            this.next = newNode;
        } else {
            this.next.add(val);
        }
    }

    //返回结点
    public ListNode next() {
        return this.next;
    }

    public int val() {
        return this.val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
    //    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
}

