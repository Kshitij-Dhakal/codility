package np.com.kshitij.codility.lessons.caterpillar.method;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbsDistinct {

    private static final String ABS_DISTINCT_SOLUTION = "Abs distinct solution : {}";

    public static void main(String[] args) {
        log.info(ABS_DISTINCT_SOLUTION, new AbsDistinct().solution(new int[]{-5, -3, -1, 0, 3, 6}));
        log.info(ABS_DISTINCT_SOLUTION, new AbsDistinct().solution(new int[]{0, 3, 3, 6}));
        log.info(ABS_DISTINCT_SOLUTION, new AbsDistinct().solution(new int[]{-2147483648, -1, 0, 1}));
    }

    public int solution(int[] A) {
        int c = 0;
        int x = 0;
        int y = A.length - 1;
        while (x <= y) {
            long max = Math.max(Math.abs((long) A[x]), Math.abs((long) A[y]));
            while (x <= y && Math.abs((long) A[x]) == max) {
                x++;
            }
            while (x <= y && Math.abs((long) A[y]) == max) {
                y--;
            }
            c++;
        }
        return c;
    }
}
