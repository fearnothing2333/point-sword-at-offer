/**
 * 丑数
 * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。习惯上我们把 1 当做是第一个丑数。求按从小到大的顺序的第 N 个丑数。
 */

public class GetUglyNumber {
    public int GetUglyNumber_Solution(int N) {
        if (N <= 6)
            return N;
        int[] dp = new int[N];
        int i2 = 0, i3 = 0, i5 = 0;//对应dp数组的下标
        dp[0] = 1;//第一个丑数肯定是1
        for (int i = 1; i < N; i++) {//所以下标从1开始赋值
            int next2 = dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));//dp[i]为三个值中最小的
            if (dp[i] == next2)
                i2++;
            if (dp[i] == next3)
                i3++;
            if (dp[i] == next5)
                i5++;
        }
        return dp[N - 1];
    }

    public static void main(String[] args) {
        GetUglyNumber getUglyNumber = new GetUglyNumber();
        int i = getUglyNumber.GetUglyNumber_Solution(25);
    }
}
