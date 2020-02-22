/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int index = s.indexOf(c);
            int last = s.lastIndexOf(c);
            if (index == last) {//如果正序查找的索引数等于倒序查找的索引数，说明该字符只出现过一次
                return index;
            }
        }
        return -1;
    }
}
