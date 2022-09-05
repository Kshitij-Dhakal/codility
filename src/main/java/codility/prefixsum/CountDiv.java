package codility.prefixsum;

public class CountDiv {
    public int solution(int a, int b, int k) {
        a = (int) (Math.ceil(a / (double) k) * k);
        b = (int) (Math.floor(b / (double) k) * k);
        if (a == b) {
            return 1;
        } else if (a > b) {
            return 0;
        } else {
            return (b - a) / k + 1;
        }
    }

    public static void main(String[] args) {
        CountDiv countDiv = new CountDiv();
        int expected = 3;
        int actual = countDiv.solution(6, 11, 2);
        assert expected == actual : String.format("Expected %d, got %d", expected, actual);
    }
}
