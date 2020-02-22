package leetcode.stringTest;

/**
 * 判断一个数是不是回文数
 * 要求不能使用额外空间，也就不能将整数转换为字符串进行判断。
 * <p>
 * 将整数分成左右两部分，右边那部分需要转置，然后判断这两部分是否相等。
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int right = 0;
        while (x > right) {//x在以10的整数倍减小，right以相反的方式增加
            right = right * 10 + x % 10;
            x /= 10;
        }
        return x == right || x == right / 10;
    }

    public static void main(String[] args) {
        IsPalindrome a = new IsPalindrome();
        a.isPalindrome(69196);
    }
}
