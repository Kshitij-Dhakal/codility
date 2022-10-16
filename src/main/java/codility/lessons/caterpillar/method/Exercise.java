package codility.lessons.caterpillar.method;

public class Exercise {
    public static void main(String[] args) {
        Exercise ex = new Exercise();
        System.out.println(ex.caterpillarMethod(new int[]{6, 2, 7, 4, 1, 3, 6}, 12));
    }

    public boolean caterpillarMethod(int[] a, int s) {
        int sum = 0;
        int i = 0;
        int from = 0;
        while (i < a.length - 1) {
            sum += a[i++];
            if (sum == s) {
                return true;
            } else if (sum > s) {
                sum = sum - a[from];
                from++;
            }
        }
        return false;
    }
}
