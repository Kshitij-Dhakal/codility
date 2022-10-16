package codility.prefixsum;

public class PassingCars {
    public static void main(String[] args) {
        PassingCars p = new PassingCars();
        System.out.println(p.solution(new int[]{0, 0, 1, 1}));
        System.out.println(p.solution(new int[]{0, 1, 0, 1, 1}));
        System.out.println(p.solution(new int[]{1, 0, 0, 1, 1, 1}));
        System.out.println(p.solution(new int[]{0, 0, 0, 0}));
        System.out.println(p.solution(new int[]{1, 1, 1, 1}));
        System.out.println(p.solution(new int[]{1, 1}));
        System.out.println(p.solution(new int[]{1, 0})); //doesn't cross
        System.out.println(p.solution(new int[]{0, 0}));
        System.out.println(p.solution(new int[]{0, 1}));
        System.out.println(p.solution(new int[]{0}));
        System.out.println(p.solution(new int[]{1}));
    }

    public int solution(int[] A) {
        int[] p = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            p[i + 1] = p[i] + A[i];
        }
        int total = 0;
        if (p[A.length] == 0 || p[A.length] == A.length) {
            return 0;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                total += p[A.length] - p[i];
            }
            if (total > 1_000_000_000)
                return -1;
        }
        return total;
    }
}
