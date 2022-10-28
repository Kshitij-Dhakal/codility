package np.com.kshitij.codility.lessons.stack.and.queues;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
public class Brackets {
    public static void main(String[] args) {
        Brackets b = new Brackets();
        log.info("Brackets solution : {}", b.solution("{[()()]}"));
    }

    public int solution(String S) {
        // write your code in Java SE 8
        Deque<Character> chStack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            if (!chStack.isEmpty() && isMatchingPair(chStack.peek(), S.charAt(i))) {
                chStack.pop();
            } else {
                chStack.push(S.charAt(i));
            }
        }
        return chStack.isEmpty() ? 1 : 0;
    }

    private boolean isMatchingPair(char a, char b) {
        if (a == '{' && b == '}') {
            return true;
        } else if (a == '[' && b == ']') {
            return true;
        } else return a == '(' && b == ')';
    }
}
