package np.com.kshitij.codility.lessons.bfs;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class CoinExchange {

    private static final String COIN_EXCHANGE_SOLUTION = "Coin exchange solution : {}";

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

    public int getChange(int[] coins, int n) {
        int d = 0;
        List<Integer> possibleOptions = new ArrayList<>();
        possibleOptions.add(n);
        Map<Integer, Integer> parentRef = new HashMap<>();
        while (true) {
            List<Integer> newOptions = new ArrayList<>();
            for (var rem : possibleOptions) {
                for (int coin : coins) {
                    int newNode = rem - coin;
                    if (newNode >= 0 && !parentRef.containsKey(newNode)) {
                        newOptions.add(newNode);
                        parentRef.put(newNode, coin);
                    }
                    if (parentRef.containsKey(0)) {
                        int currentCoin = 0;
                        List<Integer> solution = new ArrayList<>();
                        while (parentRef.containsKey(currentCoin)) {
                            solution.add(parentRef.get(currentCoin));
                            currentCoin += parentRef.get(currentCoin);
                        }
//                        System.out.println(solution);
                        return d + 1;
                    }
                }
            }
            d++;
            possibleOptions = newOptions;
        }
    }
}
