package codility.maximum.slice;

public class MaximumSlice {
    private int maximumSliceSum(int[] arr) {
        int maxEndSum = 0;
        int maxSliceSum = 0;

        //maximum sum of slice ending at i = maxEndSum(i)
        //maxEndSum(i) = max(0, maxEndSum(i-1))
        //example,
        //let's say maxEndSum at i-1 is 10 and ith element is 11. Then max end sum at i is 21.
        //let's say maxEndSum at i-1 is 10 and ith element is -11. Then max end sum at i is obviously 1.
        for (int i : arr) {
            maxEndSum = Math.max(0, maxSliceSum + i);
            maxSliceSum = Math.max(maxEndSum, maxSliceSum);
        }
        return maxSliceSum;
    }
}
