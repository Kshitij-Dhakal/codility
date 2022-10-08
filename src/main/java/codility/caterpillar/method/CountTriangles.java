package codility.caterpillar.method;

import java.util.Arrays;

public class CountTriangles {
    public int solution(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int h = 0; h + 2 < A.length; h++) {
            //2,3,4,5
            for (int m = h + 1; m + 1 < A.length; m++) {
                int t = h + 2;
                while (t < A.length && A[h] > A[t] - A[m]) {
                    t++;
                }
                count += t - m - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountTriangles().solution(new int[]{10, 2, 5, 1, 8, 12}));
    }
}
