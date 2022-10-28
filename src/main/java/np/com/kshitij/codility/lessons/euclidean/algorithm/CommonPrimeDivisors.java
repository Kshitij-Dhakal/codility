package np.com.kshitij.codility.lessons.euclidean.algorithm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonPrimeDivisors {

    private static final String COMMON_PRIME_DIVISORS_SOLUTION = "Common prime divisors solution : {}";

    public static void main(String[] args) {
        log.info(COMMON_PRIME_DIVISORS_SOLUTION, new CommonPrimeDivisors().lcm(15, 75));
        log.info(COMMON_PRIME_DIVISORS_SOLUTION, new CommonPrimeDivisors().lcm(10, 30));
        log.info(COMMON_PRIME_DIVISORS_SOLUTION, new CommonPrimeDivisors().lcm(3, 5));
        log.info(COMMON_PRIME_DIVISORS_SOLUTION, new CommonPrimeDivisors().solution(new int[]{15, 10, 3}, new int[]{75, 30, 5}));
    }

    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[i];
            if (a == 1 && b == 1) {
                count++;
            } else {
                int g = gcf(A[i], B[i]);
                while (gcf(a, g) != 1) {
                    a /= gcf(a, g);
                }
                while (gcf(b, g) != 1) {
                    b /= gcf(b, g);
                }
                if (a == 1 && b == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public int lcm(int a, int b) {
        return a * b / gcf(a, b);
    }

    public int gcf(int a, int b) {
        if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        }
        if (a == b) {
            return a;
        } else if (a > b) {
            return gcf(a % b, b);
        } else {
            return gcf(b % a, a);
        }
    }
}
