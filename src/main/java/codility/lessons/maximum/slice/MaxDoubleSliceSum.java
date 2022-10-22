package codility.lessons.maximum.slice;

public class MaxDoubleSliceSum {
    public int solution(int[] A) {
        int[] lr = new int[A.length];
        int[] rl = new int[A.length];
        for (int i = 1; i < A.length - 1; i++) {
            lr[i] = Math.max(0, lr[i - 1] + A[i]);
        }
        for (int i = A.length - 2; i >= 0; i--) {
            rl[i] = Math.max(0, rl[i + 1] + A[i]);
        }
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (i + 2 < A.length) {
                max = Math.max(lr[i] + rl[i + 2], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxDoubleSliceSum().solution(new int[]{3, 2, 6, -1, 4, 5, -1, 2}));
        System.out.println(new MaxDoubleSliceSum().solution(new int[]{5, 17, 0, 3}));
        System.out.println(new MaxDoubleSliceSum().solution(new int[]{0, 10, -5, -2, 0}));
        System.out.println(new MaxDoubleSliceSum().solution(new int[]{5, 5, 5}));
        System.out.println(new MaxDoubleSliceSum().solution(new int[]{-8, 10, 20, -5, -7, -4}));
        System.out.println(new MaxDoubleSliceSum().solution(new int[]{6, 1, 5, 6, 4, 2, 9, 4}));
    }
}
