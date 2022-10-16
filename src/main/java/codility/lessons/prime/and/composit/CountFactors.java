package codility.lessons.prime.and.composit;

public class CountFactors {
    public static int solution(int n) {
        int count = 1;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            return count * 2 - 1;
        } else {
            return count * 2;
        }
    }

    private static int getPrimeDivisor(int n, int d) {
        for (int i = d; i * i < n; i++) {
            if (n % i == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(24));
    }
}
