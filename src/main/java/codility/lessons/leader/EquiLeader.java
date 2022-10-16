package codility.lessons.leader;

import java.util.ArrayDeque;
import java.util.Deque;

public class EquiLeader {
    public static void main(String[] args) {
        EquiLeader e = new EquiLeader();
        System.out.println(e.solution(new int[]{4, 3, 4, 4, 4, 2}));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8

        int leader = getLeader(A);
        int[] counter = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == leader) {
                counter[i + 1] = counter[i] + 1;
            } else {
                counter[i + 1] = counter[i];
            }
        }
        //number of occurrences between m and n = C[n+1] - C[m]
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int c1 = counter[i + 1] - counter[0]; //number of occurrences of leader between 0 and i
            int c2 = counter[A.length] - counter[i + 1]; //number of occurrences of leader between i+1 and A.length - 1
            if (c1 > (i + 1) / 2 && c2 > (A.length - i - 1) / 2) {
                count++;
            }
        }
        return count;
    }

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
