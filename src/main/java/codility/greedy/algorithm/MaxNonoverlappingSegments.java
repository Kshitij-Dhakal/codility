package codility.greedy.algorithm;

public class MaxNonoverlappingSegments {
    public static void main(String[] args) {
        System.out.println(new MaxNonoverlappingSegments().solution(new int[]{1, 3, 7, 9, 9}, new int[]{5, 6, 8, 9, 10}));
    }

    public int solution(int[] A, int[] B) {
        int currentPosition = -1;
        int segmentCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > currentPosition) {
                segmentCount++;
                currentPosition = B[i];
            }
        }
        return segmentCount;
    }
}
