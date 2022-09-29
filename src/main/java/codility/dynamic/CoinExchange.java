package codility.dynamic;

import java.util.ArrayList;
import java.util.List;

public class CoinExchange {

    public int getChange(int[] coins, int n) {
        int d = 0;
        List<Integer> possibleOptions = new ArrayList<>();
        possibleOptions.add(n);
        while (true) {
            List<Integer> newOptions = new ArrayList<>();
            for (var rem : possibleOptions) {
                for (int coin : coins) {
                    if (rem - coin > 0) {
                        newOptions.add(rem - coin);
                    } else if (rem - coin == 0) {
                        return d + 1;
                    }
                }
            }
            d++;
            possibleOptions = newOptions;
        }
    }

    public static void main(String[] args) {
        CoinExchange ce = new CoinExchange();
        System.out.println(ce.getChange(new int[]{1, 3, 4, 5}, 7));
        System.out.println(ce.getChange(new int[]{1, 3, 4, 5}, 8));
        System.out.println(ce.getChange(new int[]{1, 3, 4, 5}, 9));
        System.out.println(ce.getChange(new int[]{1, 3, 4, 5}, 10));
        System.out.println(ce.getChange(new int[]{1, 3, 4, 5}, 15));
    }
}
