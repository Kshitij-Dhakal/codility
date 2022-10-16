package codility.lessons.maximum.slice;

public class MaximumSlice {
    private int maximumSliceSum(int[] arr) {
        int maxEndSum = 0;
        int maxSliceSum = Integer.MIN_VALUE;

        //maximum sum of slice ending at i = maxEndSum(i)
        //maxEndSum(i) = max(0, maxEndSum(i-1) + arr[i])
        for (int i : arr) {
            maxEndSum = Math.max(i, maxEndSum + i);
            maxSliceSum = Math.max(maxEndSum, maxSliceSum);
        }
        return maxSliceSum;
    }
}
