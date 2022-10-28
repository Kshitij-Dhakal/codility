package np.com.kshitij.codility.lessons.sorting;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] > A[i + 2] - A[i + 1]) {
                return 1;
            }
        }
        return 0;
    }
}
