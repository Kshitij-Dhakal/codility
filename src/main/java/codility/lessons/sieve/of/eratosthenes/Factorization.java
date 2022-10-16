package codility.lessons.sieve.of.eratosthenes;

import java.util.LinkedList;
import java.util.List;

public class Factorization {
    public static int[] arrayF(int n) {
        int[] f = new int[n + 1];
        for (int i = 2; i * i < n; i++) {
            int k = i * i;
            while (k <= n) {
                if (f[k] == 0) {
                    f[k] = i;
                }
                k += i;
            }
        }
        return f;
    }

    public static List<Integer> factorize(int n) {
        int[] f = arrayF(n);
        List<Integer> factors = new LinkedList<>();
        while (f[n] > 0) {
            factors.add(f[n]);
            n = n / f[n];
        }
        factors.add(n);
        return factors;
    }

    public static void main(String[] args) {
        System.out.println(factorize(20));
    }
}
