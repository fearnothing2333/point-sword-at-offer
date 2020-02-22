/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    /**
     * 方法一：创建一个新数组，时间复杂度 O(N)，空间复杂度 O(N)。
     *
     * @param arr 传入的数组
     */
    public static void reOrderArray(int[] arr) {
        //初始化奇数的个数为0；
        int oddConunt = 0;
        for (int x : arr) {
            if (isEven(x)) {
                oddConunt++;
            }
        }
        int[] cloneArr = arr.clone();
        int i = 0, j = oddConunt;
        for (int num : cloneArr) {
            if (isEven(num)) {//如果是偶数，就从奇数数量下标的位置开始覆盖
                arr[j++] = num;
            } else {//如果是奇数，就是零下标位置开始覆盖
                arr[i++] = num;
            }
        }
    }

    private static boolean isEven(int x) {
        return x % 2 == 0;
    }

    /**
     * 冒泡思想
     */
    public static void reOrderArray2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] % 2 == 0 && arr[j + 1] % 2 == 1) {//每次把偶数放到最右边，所以下次循环的时候不应该遍历
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
