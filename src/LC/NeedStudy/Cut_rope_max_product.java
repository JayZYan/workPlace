package LC;

public class Cut_rope_max_product {

    private int ropCut(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 0; j <= i / 2; j++) {
                int cur = Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]);
                curMax = Math.max(curMax, cur);
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Cut_rope_max_product test = new Cut_rope_max_product();
        System.out.println(test.ropCut(4));

    }

}
