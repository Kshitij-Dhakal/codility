package np.com.kshitij.codility.lessons.prime.and.composit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Peaks {
    public int solution(int[] A) {
        int[] peaks = new int[A.length];
        int[] ps = new int[A.length + 1];
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks[i] = 1;
            }
            ps[i + 1] = ps[i] + peaks[i];
        }
        ps[A.length] = ps[A.length - 1] + peaks[A.length - 1];
        int n = ps[A.length - 1]; // There can be at most as many block as there are peaks
        if (n == 0) {
            return 0;
        }
        while (n > 0) {
            if (A.length % n != 0) {
                n--;
                continue;
            }
            int k = A.length / n;
            boolean hasPeakInAllBlock = true;
            for (int i = 0; i < A.length; i += k) {
                if (ps[i + k] == ps[i]) { // comparing i+k and i instead of i+k and i+1, because if first element is peak then i+k and i+1 will be equal
                    hasPeakInAllBlock = false;
                    break;
                }
            }
            if (hasPeakInAllBlock) {
                return n;
            }
            n--;
        }
        return n;
    }

    public static void main(String[] args) {
        log.info("Peaks solution : {}", new Peaks().solution(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
        log.info("Peaks solution : {}", new Peaks().solution(new int[]{1, 2, 3, 1}));
    }
}
