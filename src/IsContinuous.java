import java.util.Arrays;

/**
 * 大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,可以认为大小王是0。
 */
public class IsContinuous {
    public boolean isContinuous(int[] nums) {
        if (nums.length < 5)
            return false;
        Arrays.sort(nums);
        // 统计癞子数量
        int cnt = 0;
        for (int num : nums)
            if (num == 0)
                cnt++;
        // 使用癞子去补全不连续的顺子
        for (int i = cnt; i < nums.length - 1; i++) {//数组下标为cut的值开始不是癞子
            if (nums[i + 1] == nums[i])//如果有两种牌相同，肯定凑不成顺子
                return false;
            cnt -= nums[i + 1] - nums[i] - 1;//补掉牌与牌之间的差值
        }
        return cnt >= 0;
    }
}
