package np.com.kshitij.codility.lessons.maximum.slice;

import java.util.LinkedList;
import java.util.List;

public class MaxProfit {

    //this problem can be solved in two parts
    //1. first find all the profit/loss between two consecutive days
    //2. find the maxSliceSum from above array (sum from profit/loss between consecutive days between p and q days is the profit/loss between p and q days)
    public int solution(int[] A) {
        // write your code in Java SE 8
        List<Integer> diff = new LinkedList<>();
        for (int i = 1; i < A.length; i++) {
            diff.add(A[i] - A[i - 1]); //profit or loss between two consecutive days
        }
        int maxEnd = 0;
        int maxSlice = 0;
        //sum of profit between a,b and b,c is the profit between a and c
        //proof
        //profit(a,b) = b-a
        //profit(b,c) = c-b
        //profit(a,c) = c-a
        //profit(a,b) + profit(b,c) = b-a+c-b = c-a = profit(a,c)
        for (int i : diff) {
            maxEnd = Math.max(0, maxEnd + i);
            maxSlice = Math.max(maxEnd, maxSlice);
        }
        return maxSlice;
    }
}
