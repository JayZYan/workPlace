package LC;

public class Maximum_Sum_Increasing_SubSequence {
    public int findSum(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = arr[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = dp[j] + arr[i];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }




    public static void main(String[] args) {

        Maximum_Sum_Increasing_SubSequence test = new Maximum_Sum_Increasing_SubSequence();
        int[] arr = new int[]{1, 101, 2, 3, 100, 4, 5};

        System.out.println("Sum of maximum sum "+
                "increasing subSequence is "+
                test.findSum(arr));
    }
}
