package recursion;

/**
 * 八皇后：8*8的棋盘，皇后之间不能直接击杀，即，皇后与皇后之间不能在同一行同一列和同一斜线
 */
public class Queue8 {
    //共有八个皇后
    int max = 8;

    int count = 0;
    //保存皇后放置的位置
    int[] arr = new int[max];

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(queue8.count);
    }

    private void check(int th) {//递归加循环，实际上是嵌套循环
        if (th == max) {//由于数组下标从零开始，所以当th等于max(8)的时候，就已经放完了max(8)个的皇后
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            //把第th个皇后（也就是第th行）放到第i列
            arr[th] = i;
            if (judge(th)) {//不冲突
                check(th + 1);
            }
        }
    }

    /**
     * 判断是否与之前的皇后在同一列或同一斜线上
     *
     * @param th
     * @return
     */
    private boolean judge(int th) {
        for (int i = 0; i < th; i++) {
            /**
             * 一、是否在同一列
             * 二、是否在同一斜线
             */
            if (arr[i] == arr[th] || Math.abs(th - i) == Math.abs(arr[th] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {//打印数组：且做+1处理
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + 1 + " ");
        }
        System.out.println();
        count++;
    }
}
