package codility.lessons.stack.and.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class StoneWall {
    public int solution(int[] H) {
        // write your code in Java SE 8
        int blocks = 0;
        Deque<Integer> blockStack = new ArrayDeque<>();
        for (int i : H) {
            if (!blockStack.isEmpty() && blockStack.peek() < i) {
                blockStack.push(i);
                blocks++;
            } else {
                while (!blockStack.isEmpty() && blockStack.peek() > i) {
                    blockStack.pop();
                }
                if (blockStack.isEmpty() || blockStack.peek() != i) {
                    blockStack.push(i);
                    blocks++;
                }
            }
        }
        return blocks;
    }
}
