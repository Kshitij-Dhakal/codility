package codility.prime.and.composit;

public class MinPerimeterRectangle {
    public static int solution(int N) {
        int l = (int) Math.sqrt(N);
        while (l > 1) {
            if (N % l == 0) {
                break;
            } else {
                l--;
            }
        }
        return 2 * (l + N / l);
    }

    public static void main(String[] args) {
        System.out.println(solution(30));
    }
}
