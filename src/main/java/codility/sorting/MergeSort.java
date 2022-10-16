package codility.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] arr = new int[]{5, 3, 2, 6, 7, 4, 1, 9, 0, 8};
        ms.sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public void merge(int[] arr, int l, int m, int r) {
        int[] a1 = Arrays.copyOfRange(arr, l, m + 1);
        int[] a2 = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                arr[l + k] = a1[i++];
                k++;
            } else {
                arr[l + k] = a2[j++];
                k++;
            }
        }
        while (i < a1.length) {
            arr[l + k] = a1[i++];
            k++;
        }
        while (j < a2.length) {
            arr[l + k] = a2[j++];
            k++;
        }
    }
}
