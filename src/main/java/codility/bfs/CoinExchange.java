package codility.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinExchange {

    public static void main(String[] args) {
        CoinExchange ce = new CoinExchange();
        System.out.println(ce.getChange(new int[]{1, 3, 4}, 6));
        System.out.println(ce.getChange(new int[]{1, 3, 4, 5}, 7));
        System.out.println(ce.getChange(new int[]{1, 3, 4, 5}, 8));
        System.out.println(ce.getChange(new int[]{1, 3, 4, 5}, 9));
        System.out.println(ce.getChange(new int[]{1, 3, 4, 5}, 10));
        System.out.println(ce.getChange(new int[]{1, 3, 4, 5}, 15));
        System.out.println(ce.getChange(new int[]{1, 2, 5}, 106));
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
