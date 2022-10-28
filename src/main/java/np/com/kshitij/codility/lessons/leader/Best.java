package np.com.kshitij.codility.lessons.leader;

import java.util.ArrayDeque;
import java.util.Deque;

public class Best {
    public int getLeader(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : arr) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (stack.peek() != i) {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        if (!stack.isEmpty()) {
            int candidate = stack.peek();
            int count = 0;
            for (int i : arr) {
                if (candidate == i) {
                    count++;
                }
            }
            if (count > arr.length / 2) {
                return candidate;
            }
        }
        return -1;
    }
}
