package offer;

/**
 * 剑指offer跳台阶问题
 */
public class Offer10 {

    public static int numWays(int n) {
        if(n <= 1) {
            return 1;
        }
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numWays(44));
    }

}
