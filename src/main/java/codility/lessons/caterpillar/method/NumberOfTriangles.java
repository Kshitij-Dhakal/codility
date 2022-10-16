package codility.lessons.caterpillar.method;

public class NumberOfTriangles {
    public static void main(String[] args) {
        NumberOfTriangles n = new NumberOfTriangles();
        System.out.println(n.triangles(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    public int triangles(int[] arr) {
        int result = 0;
        for (int x = 0; x < arr.length; x++) {
            int z = x + 2;
            for (int y = x + 1; y < arr.length; y++) {
                while (z < arr.length && arr[x] + arr[y] > z) {
                    z++;
                }
                result += z - y - 1;
            }
        }
        return result;
    }
}
