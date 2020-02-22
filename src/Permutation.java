import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个字符串，按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
 */
public class Permutation {
    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> permutation(String str) {
        if (str.length() == 0)
            return ret;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);//对字符数组排序
        backtracking(chars, new boolean[chars.length], new StringBuilder());//辅助布尔数组
        for (String s : ret) {
            System.out.println(s);
        }
        return ret;
    }

    private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if (s.length() == chars.length) {//字符数组长度等于字符长度说明遍历完
            ret.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i])//确保该字符还未排过序
                continue;
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) /* 保证不重复 */
                continue;
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.permutation("abc");
    }
}
