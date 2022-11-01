package np.com.kshitij.codility.lessons.sieve.of.eratosthenes;

import np.com.kshitij.commons.Printer;

public class CountSemiprimes {
    public static void main(String[] args) {
        Printer.print(new CountSemiprimes().solution(27, new int[]{1, 4, 16}, new int[]{26, 10, 20}));
    }

    public int[] solution(int N, int[] P, int[] Q) {
        // write your code in Java SE 8
        int[] s = new int[N + 1];
        for (int i = 2; i * i < N + 1; i++) {
            int k = i * i;
            while (k <= N) {
                if (s[k] == 0) {
                    s[k] = i;
                }
                k += i;
            }
        }
        int[] sp = new int[N + 1];
        for (int i = 1; i < s.length; i++) {
            if (s[i] > 0 && s[i / s[i]] == 0) {
                sp[i]++;
            }
        }
        int[] ps = new int[N + 2];
        for (int i = 0; i < sp.length; i++) {
            ps[i + 1] = ps[i] + sp[i];
        }
        int[] sol = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            sol[i] = ps[Q[i] + 1] - ps[P[i]];
        }
        return sol;
    }
}
