package sort;

/**
 * 希尔排序
 */
public class ShellSort {
    /**
     * 换位法
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int temp = 0;
        // 增量gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
        }
    }

    /**
     * 移步法
     *
     * @param arr
     */
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int insertVal = arr[i];
                int insertIndex = i - gap;
                while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                if ((insertIndex + gap) != i) {
                    arr[insertIndex + gap] = insertVal;
                }
            }
        }
    }
}
