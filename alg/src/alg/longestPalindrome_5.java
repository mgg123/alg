package alg;

/**
 * 最长回文子串
 */
public class longestPalindrome_5 {

    public static void main(String[] agrs) {
        longestPalindromeV2("cbabd");
    }


    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

    public static String longestPalindromeV2(String s) {
         //"abba";

        //xababaf;

        int len = s.length();
        if(len == 0 || len ==1) {
            return s;
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++) {
            int dif = aroundStr(s,i,i);
            int dif2 = aroundStr(s,i,i+1);
            int realdif = Math.max(dif,dif2);

            if(realdif > (end - start)) {
                start = i - (realdif - 1) / 2;
                end = i + realdif / 2;
            }
            System.out.println(i + " " + dif +" " + dif2 +" " + realdif + " " + start + " " + end);
        }
        s = s.substring(start,end+1);
        System.out.println(s);
        return s;
    }

    private static int aroundStr(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }




}
