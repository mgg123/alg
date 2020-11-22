package array;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
 */

public class LongestIncreasingSuq_300 {

    public static int lengthOfLIS(int[] nums) {

        int[] values = new int[nums.length];
        Arrays.fill(values,1);

        int max = 0;
        for(int i = 1; i <= nums.length - 1; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    values[i] = Math.max(values[i],values[j] + 1);
                }
            }
            if(max < values[i]) {
                max = values[i];
            }
        }

        return max;

    }


    public static int part2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }



    public static void main(String[] agrs) {

        int[] nums = new int[]{9,10,2,11,7,101,18};
        part2(nums);


    }
}
