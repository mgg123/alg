package alg;

public class AlgOffer42LCOF {

    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(dp[i -1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(max,dp[i]);
        }

        return max;
    }


    public static void main(String[] agrs) {




    }

}
