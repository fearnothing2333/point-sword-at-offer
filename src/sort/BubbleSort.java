package sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        //临时变量
        //换位标记
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //前面的值大于后面的值，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {//循环中没有换过位置，说明已排好序，退出
                break;
            } else {
                flag = false;
            }
        }
    }
}
