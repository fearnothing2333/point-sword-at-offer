/**
 * 汉诺塔游戏
 */
public class Hanoitower {

    public static int cnt = 0;

    public static void main(String[] args) {
        Hanoitower hanoitower = new Hanoitower();
        hanoitower.hanoitower(7, 'A', 'B', 'C');
        System.out.println("一共走了" + cnt + "步");
    }

    /**
     * 把每次的盘分为两部分：最后一个盘和上面的盘
     *
     * @param nums
     * @param a
     * @param b
     * @param c
     */
    public static void hanoitower(int nums, char a, char b, char c) {
        if (nums == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
            cnt++;
        } else {
            hanoitower(nums - 1, a, c, b);
            System.out.println("第" + nums + "个盘从" + a + "->" + c);
            cnt++;
            hanoitower(nums - 1, b, a, c);
        }
    }
}
