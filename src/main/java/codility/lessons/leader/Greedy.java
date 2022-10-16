package codility.lessons.leader;

public class Greedy {
    public int getLeader(int[] arr) {
        for (int i : arr) {
            int count = 0;
            for (int j : arr) {
                if (i == j) {
                    count++;
                }
            }
            if (count > arr.length) {
                return i;
            }
        }
        return -1;
    }
}
