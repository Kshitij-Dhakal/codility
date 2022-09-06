package codility.prefixsum;

public class MinAvgTwoSlice {
    public int solution(int[] A) {
        // write your code in Java SE 8
        double minAvg = Double.MAX_VALUE;
        int minStart = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int sum = A[i] + A[i + 1];
            double avg = sum / (double) 2;
            if (avg < minAvg) {
                minAvg = avg;
                minStart = i;
            }
            if (i < A.length - 2) {
                sum = A[i + 2] + A[i + 1] + A[i];
                avg = sum / (double) 3;
                if (avg < minAvg) {
                    minAvg = avg;
                    minStart = i;
                }
            }
        }
        return minStart;
    }
}
