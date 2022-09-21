package codility.sieve.of.eratosthenes;

public class SieveOfEratosthenes {
    public static boolean[] sieve(int n) {
        boolean[] sieve = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            sieve[i] = true;
        }
        sieve[0] = false;
        sieve[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (sieve[i]) {
                int k = i * i;
                //we are starting with k=i*i because, we have already filtered multiples of i and numbers less than i.
                //example 2.i, 3.i are already filtered while we were processing for i=2, i=3 respectively
                while (k <= n) {
                    sieve[k] = false;
                    k += i;
                }
            }
        }
        return sieve;
    }

    public static void main(String[] args) {
        boolean[] sieve = sieve(100);
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i]) {
                System.out.println(i);
            }
        }
    }
}
