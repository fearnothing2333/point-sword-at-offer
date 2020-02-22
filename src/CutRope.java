/**
 * 把一根绳子剪成多段，并且使得每段的长度乘积最大。
 */
public class CutRope {
    /**
     * 考虑到必然有一个点把绳子分成两份，两份各自分割得出的乘积最大值，组成整条绳子乘积的最大值。
     * 因此存在最小子问题。
     * 考虑最后一步：
     * 必然有一个点，把target分成两段，两段分别构成最小子问题。
     * 两段的最大值的乘积，也是target所求的最大值。
     * 设划分点为i,f[i]表示长度为i的绳子的乘积最大值。
     * 转移方程：
     * f[i] = MAX{f[j]*f[i-j]}|0<j<i
     *
     * @param n
     * @return
     */
    public int cupRope(int n) {
        int[] dp = new int[n + 1];//dp[x]就是长度为x的剪绳子问题的最大值
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
        return dp[n];
    }

    public static void main(String[] args) {
        CutRope c = new CutRope();
        int i = c.cupRope(2);
        System.out.println(i);
    }
}
