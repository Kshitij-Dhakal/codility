package codility.leader;

import java.util.Arrays;

public class Sorted {
    public int getLeader(int[] arr) {
        Arrays.sort(arr);
        int candidate = arr[arr.length / 2];
        int count = 0;
        for (int i : arr) {
            if (i == candidate) {
                count++;
            }
        }
        if (count > arr.length / 2) {
            return candidate;
        }
        return -1;
    }
}
