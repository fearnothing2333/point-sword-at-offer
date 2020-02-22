package leetcode.greedythinking;

import java.util.Arrays;
import java.util.Comparator;

public class GreedyThinking {
    /**
     * 不重叠区间个数
     * Input: [ [1,2], [1,2], [1,2] ] Output: 2
     * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
     * Input: [ [1,2], [2,3] ]  Output: 0
     * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
     * 题目描述：计算让一组区间不重叠所需要移除的区间个数。
     * 先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
     * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
     * 按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int cnt = 1;
        int end = intervals[0][1];//第一个数的右边界作为作为end
        for (int i = 1; i < intervals.length; i++) {//遍历整个区间数组
            if (intervals[i][0] < end) {//区间左边小于右边，因之前排序了，所以右边一定大于右边即区间重叠了（可画图理解），就不计数，反之，计数。
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }

    /**
     * 题目描述：气球在一个水平数轴上摆放，可以重叠，飞镖垂直投向坐标轴，使得路径上的气球都被刺破。求解最小的投飞镖次数使所有气球都被刺破。
     * <p>
     * 也是计算不重叠的区间个数，不过和 Non-overlapping Intervals 的区别在于，[1, 2] 和 [2, 3] 在本题中算是重叠区间。
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int cnt = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }

    /**
     * 种植花朵
     * Input: flowerbed = [1,0,0,0,1], n = 1  Output: True
     * 题目描述：flowerbed 数组中 1 表示已经种下了花朵。花朵之间至少需要一个单位的间隔，求解是否能种下 n 朵花。
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < len && cnt < n; i++) {//遍历数组
            if (flowerbed[i] == 1) {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];//取出i下标前一个数，如果i=0,就把前一个数当作是零
            int next = i == len - 1 ? 0 : flowerbed[i + 1];//取出下标后一个数，如果是最后一个数，就把后一个数当做是零
            if (pre == 0 && next == 0) {//若前后都为零
                cnt++;//计数-也就是可以插花
                flowerbed[i] = 1;//并把花插上，不然容易重复数；
            }
        }
        return cnt >= n;
    }

    /**
     * 判断是否为子字符串
     * s = "abc", t = "ahbgdc"
     * Return true.
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {//遍历需要判断的每个字符
            index = t.indexOf(c, index + 1);//每次判断完后将索引重新赋值，下次就会从新索引位置开始判断
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Input: [4,2,3]
     * Output: True
     * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
     * 题目描述：判断一个数组是否能只修改一个数就成为非递减数组。
     * <p>
     * 在出现 nums[i] < nums[i - 1] 时，需要考虑的是应该修改数组的哪个数，
     * 使得本次修改能使 i 之前的数组成为非递减数组，并且 不影响后续的操作 。
     * 优先考虑令 nums[i - 1] = nums[i]，因为如果修改 nums[i] = nums[i - 1] 的话，
     * 那么 nums[i] 这个数会变大，就有可能比 nums[i + 1] 大，从而影响了后续操作。
     * 还有一个比较特别的情况就是 nums[i] < nums[i - 2]，修改 nums[i - 1] = nums[i] 不能使数组成为非递减数组，
     * 只能修改 nums[i] = nums[i - 1]。
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        //因为是修改一个数，所以只有两种方法：一、把当前数变大，二、把前面一个数变小
        //第一种情况：如果第i-2个数比自己还大，就应该把自己变大 如：6、7、3、8、9,6比3大，应当把3变为7
        //如果不是这张情况就应该把第i-1个数变小 如1、5、4、6、8，应当把5改为4
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i] >= nums[i - 1]) {//当前数大于前一个数，说明递增，符合要求，跳过当前循环
                continue;
            }
            cnt++;//否则记录有问题的数
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
            if (cnt >= 2) {
                return false;
            }
        }
        return cnt <= 1;
    }

    /**
     * 10. 子数组最大的和
     * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
     * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preSum = nums[0];
        int maxSum = preSum;
        for (int i = 1; i < nums.length; i++) {
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];//前一个数是正数就相加现在的数并覆盖为前一个数，否则把现在的数覆盖为前一个数
            maxSum = Math.max(maxSum, preSum);//
            System.out.println(preSum + "  " + maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
    }
}
