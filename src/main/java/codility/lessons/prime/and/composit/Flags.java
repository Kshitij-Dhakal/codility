package codility.lessons.prime.and.composit;

public class Flags {
    // TODO: 9/20/22

    public int solution(int[] A) {
        int[] peaks = new int[A.length];
        int peaksCount = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks[i] = 1;
                peaksCount++;
            }
        }
        int root = (int) Math.sqrt(A.length) + 1;
        int n = Math.min(peaksCount, root);
        while (n > 0) {
            int flags = 0;
            for (int i = 0; i < A.length; i++) {
                if (peaks[i] == 1) {
                    flags++;
                    i += n - 1;
                }
            }
            if (flags >= n) {
                return n;
            } else {
                n--;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new Flags().solution(new int[]{1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
    }
}
