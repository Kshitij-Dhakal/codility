package codility.lessons.sorting;

import java.util.Arrays;

public class MaxProductOfThree {
    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int length = A.length;
        if (length == 0) {
            return 1;
        } else if (length == 1) {
            return A[0];
        } else if (length == 2) {
            return A[0] * A[1];
        } else {
            return Math.max(A[length - 3] * A[length - 2] * A[length - 1],
                    A[0] * A[1] * A[length - 1]);
        }
    }
}
