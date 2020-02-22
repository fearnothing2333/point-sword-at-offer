
public class Test02 {
    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例
     * 如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
     * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        StringBuilder builder = new StringBuilder();

        //将整型数组填满字符串
        for (int i = 0; i < length; i++) {
            builder.append(numbers[i] + "");
        }

        //遍历字符串每个字符，如果该字符的顺序下标不等于逆序下标，说明该字符重复，否则不重复
        for (int j = 0; j < length; j++) {
            if (builder.indexOf(numbers[j] + "") != builder.lastIndexOf(numbers[j] + "")) {
                duplication[0] = numbers[j];
                return true;
            }
        }

        return false;
    }
}
