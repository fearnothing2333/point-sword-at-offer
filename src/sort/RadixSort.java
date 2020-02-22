package sort;

/**
 * 基数排序
 * 关键词与步骤：桶、记录数组、装水、倒水
 */
public class RadixSort {
    private static int[] counts = new int[10];//初始化一个记录数组,数组下标对应桶的序号数，下标对应的值为该桶所存记录数

    public static void radixSort(int[] arr) {
        //找出最大的数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //确定最大数有多少位
        int maxLen = (max + "").length();
        //造桶
        int[][] bucket = new int[10][arr.length];
        //循环装水倒水
        for (int i = 0, n = 1; i < maxLen; i++, n *= 10) {//根据第i(个、十、百、千...)位的大小来排序
            //装水，遍历传入的数组
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;//确定该元素第i位是多少
                bucket[digitOfElement][counts[digitOfElement]] = arr[j];//装入对应的桶
                counts[digitOfElement]++;//该桶所装数的记录加一
            }
            //倒水，遍历每个桶
            int index = 0;
            for (int k = 0; k < 10; k++) {
                if (counts[k] > 0) {//如果该桶有记录数
                    for (int l = 0; l < counts[k]; l++) {//就遍历该桶，并把该桶所存数据覆盖到传入数组
                        arr[index++] = bucket[k][l];
                    }
                }
                counts[k] = 0;//最后把该桶记录数清零
            }
        }
    }
}
