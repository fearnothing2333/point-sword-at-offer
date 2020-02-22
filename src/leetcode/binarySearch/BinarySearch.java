package leetcode.binarySearch;

public class BinarySearch {
    /**
     * 最基础的二分查找
     *
     * @param nums
     * @param key
     * @return
     */
    public int binarySearch(int[] nums, int key) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;//使用(l+h)/2也行，但是l+h很有可能超出int的范围
            if (nums[m] == key) {
                return m;
            } else if (nums[m] > key) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找可以有很多变种，实现变种要注意边界值的判断。例如在一个有重复元素的数组中查找 key 的最左位置的实现如下：
     * 该实现和正常实现有以下不同：
     * h 的赋值表达式为 h = m
     * 循环条件为 l < h
     *
     * @param nums
     * @param key
     * @return
     */
    public int binarySearch2(int[] nums, int key) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= key) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    /**
     * Input: 4 Output: 2
     * Input: 8 Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
     * 一个数 x 的开方 sqrt 一定在 0 ~ x 之间，并且满足 sqrt == x / sqrt。可以利用二分查找在 0 ~ x 之间查找 sqrt。
     * <p>
     * 对于 x = 8，它的开方是 2.82842...，最后应该返回 2 而不是 3。
     * 在循环条件为 l <= h 并且循环退出时，h 总是比 l 小 1，
     * 也就是说 h = 2，l = 3，因此最后的返回值应该为 h 而不是 l。
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1, h = x;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (mid > sqrt) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }
}
