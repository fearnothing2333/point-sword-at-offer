package leetcode.stringTest;

/**
 * 判断两字符串是否有相同字符；
 * 如 s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 可以用 HashMap 来映射字符与出现次数，然后比较两个字符串出现的字符数量是否相同。
 * <p>
 * 由于本题的字符串只包含 26 个小写字符，因此可以使用长度为 26 的整型数组对字符串出现的字符进行统计，不再使用 HashMap。
 */

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[26];
        for (char ss : s.toCharArray()) {
            cnt[ss - 'a']++;//利用字符做运算可以提升为int类型的特性
        }
        for (char tt : t.toCharArray()) {
            cnt[tt - 'a']--;
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
