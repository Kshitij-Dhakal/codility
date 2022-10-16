package codility.greedy.algorithm;

import java.util.Arrays;

public class CoinExchange {
    public static void main(String[] args) {
        System.out.println(new CoinExchange().greedyCoinChanging(new int[]{1, 2, 5}, 23));
    }

    public int greedyCoinChanging(int[] coins, int n) {
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            count += n / coins[i];
            n = n % coins[i];
        }
        return count;
    }
}
