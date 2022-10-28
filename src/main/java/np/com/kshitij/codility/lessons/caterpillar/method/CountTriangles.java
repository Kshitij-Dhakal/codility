package np.com.kshitij.codility.lessons.caterpillar.method;

import java.util.Arrays;

public class CountTriangles {
    public static void main(String[] args) {
        System.out.println(new CountTriangles().solution(new int[]{10, 2, 5, 1, 8, 12}));
        System.out.println(new CountTriangles().solution(new int[]{1, 2, 5, 9, 10, 12, 13}));
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int h = 0; h + 2 < A.length; h++) {
            //1,2,5,9,10,12,13
            int t = h + 2;
            //let's suppose h, h+1 > some t but h,h+2 < t+1
            //then for next iteration we can continue from h, h+2 and t+1, instead of h, h+2, and (h+3, h+4, ..., t)
            //because, since h, h+1 > t, we can deduce h, h+2 > t also holds true
            for (int m = h + 1; m + 1 < A.length; m++) {
                while (t < A.length && A[h] > A[t] - A[m]) {
                    t++;
                }
                count += t - m - 1;
            }
        }
        return count;
    }
}
