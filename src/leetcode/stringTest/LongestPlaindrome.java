package leetcode.stringTest;

/**
 * 找出字符串中字符能组成的最长回文字符
 * Input : "abccccdd"
 * Output : 7
 * Explanation : One longest palindrome that can be built is "dccaccd", whose length is 7
 */
public class LongestPlaindrome {
    /**
     * 使用长度为 256 的整型数组来统计每个字符出现的个数，每个字符有偶数个可以用来构成回文字符串。
     * 因为回文字符串最中间的那个字符可以单独出现，所以如果有单独的字符就把它放到最中间。
     *
     * @param s
     * @return
     */
    public int longestPlaindrome(String s) {
        int[] counts = new int[256];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }
        int plaindrome = 0;
        for (int count : counts) {
            plaindrome += (count / 2) * 2;//字符出现n次，n为偶数，则刚好凑成回文，n为大于2的奇数，也可凑成回文
        }
        if (plaindrome < s.length()) {//小于原字符长度，说明一定存在落单的字符（落单的字符里只能取其中一个来构成回文）
            plaindrome++;
        }
        return plaindrome;
    }
}
