package codility.stack.and.queues;

import java.util.Stack;

public class Brackets {
    public int solution(String S) {
        // write your code in Java SE 8
        Stack<Character> chStack = new Stack<>();
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

    public static void main(String[] args) {
        Brackets b = new Brackets();
        System.out.println(b.solution("{[()()]}"));
    }
}
