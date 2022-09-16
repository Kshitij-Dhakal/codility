package codility.maximum.slice;

public class MaximumSlice {
    private int maximumSliceSum(int[] arr) {
        int maxEndSum = 0;
        int maxSliceSum = 0;
        for (int i : arr) {
            maxEndSum = Math.max(0, maxSliceSum + i);
            maxSliceSum = Math.max(maxEndSum, maxSliceSum);
        }
        return maxSliceSum;
    }
}
