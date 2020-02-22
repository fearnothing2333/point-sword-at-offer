import java.util.ArrayList;
import java.util.Arrays;

public class FindContinuousSequence {
    /**
     * 输出所有和为 S 的连续正数序列。
     *
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int start = 1, end = 2;
        int curSum = 3;
        while (end < sum) {
            if (curSum > sum) {//当前和的值大于目标和的值
                curSum -= start;//就应该减掉一个最小的值
                start++;//同时起点值后移
            } else if (curSum < sum) {//当前和的值小于目标和的值
                end++;//尾值就多一个
                curSum += end;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++)
                    list.add(i);
                ret.add(list);
                curSum -= start;//起点值后移
                start++;
                end++;
                curSum += end;//尾值也后移
            }
        }
        return ret;
    }

    /**
     * 和为 S 的两个数字
     * 描述:输入一个递增排序的数组和一个数字 S，在数组中查找两个数，使得他们的和正好是 S。如果有多对数字的和等于 S，输出两个数的乘积最小的。
     * 思路：
     * 使用双指针，一个指针指向元素较小的值，一个指针指向元素较大的值。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            int cur = array[i] + array[j];
            if (cur == sum)
                return new ArrayList<>(Arrays.asList(array[i], array[j]));
            if (cur < sum)
                i++;
            else
                j--;
        }
        return new ArrayList<>();//说明没找到，返回空列表
    }

    public static void main(String[] args) {
        FindContinuousSequence f = new FindContinuousSequence();
        ArrayList<ArrayList<Integer>> lists = f.FindContinuousSequence(100);
        System.out.println(lists);
    }
}
