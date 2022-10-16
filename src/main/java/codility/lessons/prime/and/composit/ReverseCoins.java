package codility.lessons.prime.and.composit;

public class ReverseCoins {
    public int coins(int n) {
        //since all the numbers except perfect squares have symmetric divisors
        //ie if a is divisor of n then (n/a) is also divisor o n. But if n is a perfect square,
        //then there exists a (sqrt(n)), whose (n/a) is also a so, there are odd number of divisors for perfect squares.
        //since every coins are turned exactly as many times as they have divisors and perfect square numbers have
        //odd number of divisors, only they will be showing tails at the end.


        //there are exactly sqrt(n) perfect squares between 1 and n.
        return (int) Math.sqrt(n);
    }
}
