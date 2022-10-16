package codility.dynamic;

public class FromJumps {
    public static void main(String[] args) {
        System.out.println(new FromJumps().solution(new int[]{2, 3}, 10, 10));
    }

    public int solution(int[] s, int k, int q) {
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 1; i < k + 1; i++) {
            for (int j : s) {
                if (j <= i) {
                    dp[i] = (dp[i] + dp[i - j]) % q;
                }
            }
        }
        return dp[k];
    }
}
