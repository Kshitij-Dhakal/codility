package codility.lessons.dynamic;

public class NumberSolitaire {
    public static void main(String[] args) {
        System.out.println(new NumberSolitaire().solution(new int[]{1, -2, 0, 9, -1, -2}));
    }

    public int solution(int[] A) {
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            dp[i] = dp[i - 1] + A[i];
            for (int j = 2; j <= 6 && i - j >= 0; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + A[i]);
            }
        }
        return dp[dp.length - 1];
    }
}
