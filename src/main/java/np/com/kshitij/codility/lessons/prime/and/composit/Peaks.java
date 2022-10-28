package np.com.kshitij.codility.lessons.prime.and.composit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Peaks {
    public int solution(int[] A) {
        int[] peaks = new int[A.length];
        int peaksCount = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks[i] = 1;
                peaksCount++;
            }
        }
        int half = (A.length / 2) + 1; // At the very least each block contains two elements to satisfy all conditions
        int n = Math.min(peaksCount, half); // There can be at most as many block as there are peaks or
        // as many blocks as half of the array's length
        while (n > 0) {
            if (A.length % n != 0) {
                n--;
                continue;
            }
            int k = A.length / n;
            boolean hasPeakInAllBlock = true;
            for (int i = 0; i < A.length; i += k) {
                boolean hasPeak = false;
                for (int j = 0; j < k; j++) {
                    int index = i + j;
                    if (peaks[index] == 1) {
                        hasPeak = true;
                        break;
                    }
                }
                if (!hasPeak) {
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
    }
}
