package codility.dynamic;

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

    public int getChange(int[] coins, int change) {
        int[][] d = new int[coins.length + 1][change + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            for (int j = 0; j < change + 1; j++) {
                if (j == 0) {
                    d[i][j] = 0;
                } else if (i == 0) {
                    d[i][j] = Integer.MAX_VALUE;
                } else {
                    int c = coins[i - 1];
                    if (j - c < 0) {
                        d[i][j] = d[i - 1][j];
                    } else {
                        d[i][j] = Math.min(d[i - 1][j], d[i][j - c] + 1);
                    }
                }
            }
        }
        return d[coins.length][change];
    }
}
