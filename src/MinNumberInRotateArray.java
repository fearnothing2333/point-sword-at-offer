/**
 * 旋转数组 如4561234是由1234567旋转1234得来；输入5671234，输出最小数为1
 * 思考：二分查找的变相；
 * 由于输入数组的特性，当中间值小于右边时，说明中间值在旋转数组中，应当把范围缩小
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[low] == array[mid] && array[mid] == array[high]) {//当有相等值时，方法失效，只好暴力查询
                for (int i = 0; i < high; i++) {
                    if (array[i] > array[i + 1]) {
                        return array[i + 1];
                    }
                }
            } else if (array[mid] <= array[high]) {//中间值小于右边值时，说明中间值在旋转数组中，缩小范围
                high = mid;
            } else {//中间值大于等于左边时，说明不在旋转组中，缩小范围
                low = mid + 1;
            }
        }
        return array[low];
    }
}
