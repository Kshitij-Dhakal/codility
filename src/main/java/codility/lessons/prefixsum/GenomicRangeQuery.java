package codility.lessons.prefixsum;

/**
 * <a href="https://www.youtube.com/watch?v=4SyckIAmYXk">Genomic Range Query Solution in Python and C++ Codility Solutions Lesson 5</a>
 */
public class GenomicRangeQuery {
    public static void main(String[] args) {
        GenomicRangeQuery obj = new GenomicRangeQuery();
        for (int v : obj.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})) {
            System.out.println(v);
        }
    }

    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int[] A = new int[S.length()];
        // for CAGCCTA, A = [0,1,0,0,0,1]
        // then calculate prefix sum, A = [0,1,1,1,1,2].
        // That way we'll know if there are occurrences of A between any two intervals
        int[] C = new int[S.length()];
        int[] G = new int[S.length()];
        int[] T = new int[S.length()];
        int a = 0, c = 0, g = 0, t = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'A') a++;
            if (S.charAt(i) == 'C') c++;
            if (S.charAt(i) == 'G') g++;
            if (S.charAt(i) == 'T') t++;
            A[i] = a;
            C[i] = c;
            G[i] = g;
            T[i] = t;
        }
        int[] s = new int[P.length];
        for (int i = 0; i < s.length; i++) {
            if (P[i] == Q[i]) {
                if (S.charAt(P[i]) == 'A') s[i] = 1;
                if (S.charAt(P[i]) == 'C') s[i] = 2;
                if (S.charAt(P[i]) == 'G') s[i] = 3;
                if (S.charAt(P[i]) == 'T') s[i] = 4;
            } else if (A[P[i]] < A[Q[i]] || S.charAt(P[i]) == 'A') {
                s[i] = 1;
            } else if (C[P[i]] < C[Q[i]] || S.charAt(P[i]) == 'C') {
                s[i] = 2;
            } else if (G[P[i]] < G[Q[i]] || S.charAt(P[i]) == 'G') {
                s[i] = 3;
            } else {
                s[i] = 4;
            }
        }
        return s;
    }
}
