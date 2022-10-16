package codility.lessons.stack.and.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class Fish {
    public int solution(int[] A, int[] B) {
        Deque<Integer> rs = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) {
                rs.push(A[i]);
            } else {
                while (!rs.isEmpty() && rs.peek() < A[i]) {
                    rs.pop();
                }
                if (rs.isEmpty()) {
                    count++; //A[i] is a safe fish moving upward in stream
                }
            }
        }
        return rs.size() + count;
    }
}
