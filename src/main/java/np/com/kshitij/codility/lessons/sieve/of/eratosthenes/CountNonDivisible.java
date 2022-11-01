package np.com.kshitij.codility.lessons.sieve.of.eratosthenes;

import np.com.kshitij.commons.Printer;

public class CountNonDivisible {
    public static void main(String[] args) {
        Printer.print(new CountNonDivisible().solution(new int[]{3, 1, 2, 3, 6}));
    }

    public int[] solution(int[] A) {
        // write your code in Java SE 8
        int max = 0;
        for (int i : A) {
            if (i > max) {
                max = i;
            }
        }
        int[] count = new int[max + 1];
        for (int i : A) {
            count[i]++;
        }
        int[] sol = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int v = A[i];
            int r = (int) Math.sqrt(v);
            for (int j = 1; j <= r; j++) {
                if (v % j == 0) {
                    int q = v / j;
                    if (q != j) {
                        sol[i] += count[q];
                    }
                    sol[i] += count[j];
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            sol[i] = A.length - sol[i];
        }
        return sol;
    }

}
