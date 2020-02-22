package sort;

/**
 * 归并排序
 */
public class MergeSort {

    //分+合方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;// 初始化i, 左边有序序列的初始索引
        int j = mid + 1;//初始化j, 右边有序序列的初始索引
        int t = 0;// 指向temp数组的当前索引
        /**
         (一)
         先把左右两边(有序)的数据按照规则填充到temp数组
         直到左右两边的有序序列，有一边处理完毕为止
         */
        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到 temp数组
            //然后 t++, i++
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {//反之,将右边有序序列的当前元素，填充到temp数组
                temp[t++] = arr[j++];
            }
        }
        //(二)
        //把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        //(三)
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        t = 0;
        int templeft = left;
        while (templeft <= right) {
            arr[templeft++] = temp[t++];
        }
    }
}
