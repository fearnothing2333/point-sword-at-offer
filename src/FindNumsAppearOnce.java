import java.util.HashMap;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        //哈希算法
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i]))
                map.put(array[i], 2);
            else
                map.put(array[i], 1);
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                if (count == 0) {
                    num1[0] = array[i];
                    count++;
                } else
                    num2[0] = array[i];
            }
        }
    }
}

