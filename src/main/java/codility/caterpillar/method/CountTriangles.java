package codility.caterpillar.method;

import java.util.Arrays;

public class CountTriangles {
    public int solution(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int h = 0; h + 2 < A.length; h++) {
            //1,2,5,8,10,12
            int t = h + 2;
            for (int m = h + 1; m + 1 < A.length; m++) {
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
