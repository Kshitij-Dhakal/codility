package np.com.kshitij.codility.lessons.dynamic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoinExchange {
    private static final String
            COIN_EXCHANGE_SOLUTION = "Coin exchange solution: {}";

    public static void main(String[] args) {
        CoinExchange ce = new CoinExchange();
        log.info(COIN_EXCHANGE_SOLUTION, ce.getChange(new int[]{1, 3, 4}, 6));
        log.info(COIN_EXCHANGE_SOLUTION, ce.getChange(new int[]{1, 3, 4, 5}, 7));
        log.info(COIN_EXCHANGE_SOLUTION, ce.getChange(new int[]{1, 3, 4, 5}, 8));
        log.info(COIN_EXCHANGE_SOLUTION, ce.getChange(new int[]{1, 3, 4, 5}, 9));
        log.info(COIN_EXCHANGE_SOLUTION, ce.getChange(new int[]{1, 3, 4, 5}, 10));
        log.info(COIN_EXCHANGE_SOLUTION, ce.getChange(new int[]{1, 3, 4, 5}, 15));
        log.info(COIN_EXCHANGE_SOLUTION, ce.getChange(new int[]{1, 2, 5}, 106));
    }

    public int getChange(int[] coins, int change) {
        int[] d = new int[change + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            for (int j = 0; j < change + 1; j++) {
                if (j == 0) {
                    d[j] = 0;
                } else if (i == 0) {
                    d[j] = Integer.MAX_VALUE;
                } else {
                    int c = coins[i - 1];
                    if (j - c >= 0) {
                        d[j] = Math.min(d[j], d[j - c] + 1);
                    }
                }
            }
        }
        return d[change];
    }
}
