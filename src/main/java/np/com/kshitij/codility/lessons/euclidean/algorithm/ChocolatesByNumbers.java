package np.com.kshitij.codility.lessons.euclidean.algorithm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChocolatesByNumbers {
    public static void main(String[] args) {
        ChocolatesByNumbers obj = new ChocolatesByNumbers();
        log.info("Chocolates by numbers solution : {}", obj.solution(10, 4));
    }

    public int solution(int N, int M) {
        return N / gcd(N, M);
    }

    private int gcd(int N, int M) {
        if (N % M == 0) {
            return M;
        }
        return gcd(M, N % M);
    }
}
