package sort;

/**
 * 快速排序
 */
public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(right + left) / 2];
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }
            //交换
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移，因为交换后的r下标的值必然大于中轴值，不用再找了
            if (arr[l] == pivot) {
                r--;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移，理由同上
            if (arr[r] == pivot) {
                l++;
            }
        }
    }
}
