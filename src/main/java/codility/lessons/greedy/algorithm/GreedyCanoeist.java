package codility.lessons.greedy.algorithm;

public class GreedyCanoeist {
    public static void main(String[] args) {
        System.out.println(new GreedyCanoeist().solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9));
    }

    public int solution(int[] a, int w) {
        int l = 0;
        int h = a.length - 1;
        int canoe = 0;
        while (l < h) {
            if (a[l] + a[h] <= w) {
                l++;
            }
            h--;
            canoe++;
        }
        return canoe;
    }
}
