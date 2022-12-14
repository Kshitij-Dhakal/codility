package np.com.kshitij.codility.lessons.greedy.algorithm;

public class TieRopes {
    public static void main(String[] args) {
        System.out.println(new TieRopes().solution(4, new int[]{1, 2, 3, 4, 1, 1, 3}));
    }

    public int solution(int K, int[] A) {
        int ropeLength = 0;
        int count = 0;
        for (int i : A) {
            ropeLength += i;
            if (ropeLength >= K) {
                ropeLength = 0;
                count++;
            }
        }
        return count;
    }
}
