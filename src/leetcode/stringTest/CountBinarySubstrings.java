package leetcode.stringTest;

/**
 * 统计二进制字符串中连续 1 和连续 0 数量相同的子字符串个数
 * Input: "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int preLen = 0, curlen = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {//从第二个字符开始
            if (s.charAt(i) == s.charAt(i - 1)) {//判断是否与前一个字符相同，如：000
                curlen++;//如果相同就把统计长度加一 接上例：count=3;
            } else {//如果不同
                preLen = curlen;//就把目前统计到的相同字符长度记下来，如0001，prelen=3,prelen=1
                count++;
            }
            if (preLen >= curlen) {//若上次统计的长度大于或等于现在长度
                count++;//说明仍然可以构成符合条件的字符串
            }
        }
        return count;
    }
}
