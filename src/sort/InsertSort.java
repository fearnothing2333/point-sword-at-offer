package sort;

/**
 * 插入排序
 */
public class InsertSort {
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //定义插入值--类似抓牌插入
            int insertVal = arr[i];
            //定义待插入索引
            int insertIndex = i - 1;
            //如果插入比待插入索引处的值大，则插入，否则将插入索引处的值往后移，待插入索引向前移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex] = arr[insertIndex + 1];//将插入索引处的值往后移
                insertIndex--;//待插入索引向前移
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    public static void main(String[] args) {
    }
}

