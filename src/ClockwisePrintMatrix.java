import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * c0  c1  c2  c3
 * r0    1   2   3   4
 * r1   5   6   7   8
 * r2  9   10  11  12
 * r3 13  14  15  16
 */
public class ClockwisePrintMatrix {
    public static ArrayList<Integer> clockwisePrintMatrix(int[][] arr) {
        ArrayList<Integer> ints = new ArrayList<>();
        int rs = 0, re = arr.length - 1, cs = 0, ce = arr[0].length - 1;//r和c分别代表row和column，s和e分别代表start和end。定义边界；
        while (rs <= re && cs <= ce) {//走完一圈，边界缩小
            for (int i = cs; i <= ce; i++) {//向右走
                ints.add(arr[rs][i]);
            }
            for (int i = rs + 1; i <= re; i++) {//向下走
                ints.add(arr[i][ce]);
            }
            if (rs != re) {//如果 rs=re 说明只剩一行了，且在向右走的时候已经走过了
                for (int i = ce - 1; i >= cs; i--) {//向左走
                    ints.add(arr[re][i]);
                }
            }
            if (cs != ce) {//如果 cs=ce 说明只剩一列了，且在向下走的时候已经走过了
                for (int i = re - 1; i > rs; i--) {//向上走
                    ints.add(arr[i][cs]);
                }
            }
            rs++;
            re--;
            cs++;
            ce--;
        }
        return ints;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        clockwisePrintMatrix(arr);
    }
}
