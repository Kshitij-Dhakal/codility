package codility.lessons.sorting;

import java.util.Arrays;

public class Distinct {
    public static void main(String[] args) {
        Distinct d = new Distinct();
        System.out.println(d.solution(new int[]{2, 1, 1, 2, 3, 1}));
    }

    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int count = 1;
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                count++;
            }
        }
        return count;
    }
}
