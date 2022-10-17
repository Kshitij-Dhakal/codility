package codility.lessons.fibonacci.number;

import java.util.ArrayList;
import java.util.List;

public class FibFrog {

    public int solution(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        List<Integer> fibs = getFibs(A.length + 1);
        if (fibs.contains(A.length + 1)) {
            return 1;
        }
        int[] s = getAllReachableIn1Jump(A, fibs);
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 0 && (i == A.length || A[i] == 1)) {
                var minSteps = Integer.MAX_VALUE;
                for (var f : fibs) {
                    if (i - f >= 0 && s[i - f] > 0) {
                        minSteps = minSteps <= s[i - f] ? minSteps : (s[i - f] + 1);
                    }
                }
                s[i] = minSteps == Integer.MAX_VALUE ? -1 : minSteps;
            }
        }
        return s[A.length];
    }

    private int[] getAllReachableIn1Jump(int[] A, List<Integer> fibs) {
        int[] s = new int[A.length + 1];
        for (var fib : fibs) {
            if (A[fib - 1] == 1) {
                s[fib - 1] = 1;
            }
        }
        return s;
    }

    private List<Integer> getFibs(int length) {
        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);
        while ((fib.get(fib.size() - 1) + fib.get(fib.size() - 2)) <= length) {
            fib.add(fib.get(fib.size() - 1) + fib.get(fib.size() - 2));
        }
        return fib;
    }

    public static void main(String[] args) {
        System.out.println(new FibFrog().solution(new int[]{0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0}));
    }
}
