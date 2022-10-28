package np.com.kshitij.codility.lessons.greedy.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class CoinExchange {
    public static void main(String[] args) {
        log.info("Coin exchange solution : {}", new CoinExchange().greedyCoinChanging(new int[]{1, 2, 5}, 23));
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
