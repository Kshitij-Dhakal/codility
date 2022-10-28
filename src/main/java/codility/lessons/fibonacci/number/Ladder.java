package codility.lessons.fibonacci.number;

public class Ladder {

    public static void main(String[] args) {
        int[] solution = new Ladder().solution(new int[]{4, 4, 5, 5, 1},
                new int[]{3, 2, 4, 3, 1});
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }

    public int[] solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int[] fib = new int[A.length + 2];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < A.length + 2; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % (1 << 30);
        }
        int[] solution = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            solution[i] = (fib[A[i] + 1]) % (1 << B[i]);
        }
        return solution;
    }
}
