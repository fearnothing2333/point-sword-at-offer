package qi_an_xin;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 最长不含重复字符的子字符串
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 */
public class MaxSubStringWithOutDuplication {
    public int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs, -1);
        for (int curI = 0; curI < str.length(); curI++) {
            int c = str.charAt(curI) - 'a';
            int preI = preIndexs[c];//该字符在字符串中上一次出现的位置
            //扫描到的字符没出现过||该字符与上一次出现位置之间有其他重复字符出现
            if (preI == -1 || curI - preI > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = curI - preI;//
            }
            preIndexs[c] = curI;//记录该字符在字符串的位置
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }

    public int getMaxSubstringWithoutDuplication(String s) {
        //定义初始返回值
        int res = 0;
        if (s.length() == 0) {
            return res;
        }
        //定义一个map用于存放并更新出现过的字符位置
        HashMap<Character, Integer> map = new HashMap<>();
        //定义左指针和右指针，双指针遍历字符串
        for (int left = 0, right = 0; right < s.length(); right++) {
            //右指针是否扫描过该字符
            if (map.containsKey(s.charAt(right))) {
                //将左指针所在下标更改
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            //存放并更新出现过的字符位置
            map.put(s.charAt(right), right);
            //存放最大的子字符串长度
            res = Math.max(res, (right - left) + 1);
        }
        return res;
    }
}
