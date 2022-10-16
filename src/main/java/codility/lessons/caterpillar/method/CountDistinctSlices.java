package codility.lessons.caterpillar.method;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctSlices {
    public static void main(String[] args) {
        System.out.println(new CountDistinctSlices().solution(6, new int[]{3, 4, 5, 5, 6}));
        System.out.println(new CountDistinctSlices().solution(100000, new int[]{100000, 10000}));
    }

    public int solution(int M, int[] A) {
        long count = 0;
        int t = 0;
        Set<Integer> c = new HashSet<>();
        for (int i : A) {
            while (t < A.length && !c.contains(A[t])) {
                c.add(A[t++]);
            }
            count += c.size();
            c.remove(i);
        }
        return count > 1_000_000_000 ? 1_000_000_000 : (int) count;
    }
}
