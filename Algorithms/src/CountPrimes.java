// https://leetcode.com/problems/count-primes/description/

// https://leetcode.com/problems/count-primes/discuss/57593/12-ms-Java-solution-modified-from-the-hint-method-beats-99.95

public class CountPrimes {
    /**
     * Count the number of prime numbers less than a non-negative number, n
     *
     * @param n a non-negative integer
     * @return the number of primes less than n
     */
    public int countPrimes(int n) {
        /**
         * if n = 2, the prime 2 is not less than n,
         * so there are no primes less than n
         */
        if (n < 3) return 0;

        /**
         * Start with the assumption that half the numbers below n are
         * prime candidates, since we know that half of them are even,
         * and so _in general_ aren't prime.
         *
         * An exception to this is 2, which is the only even prime.
         * But also 1 is an odd which isn't prime.
         * These two exceptions (a prime even and a for-sure not-prime odd)
         * cancel each other out for n > 2, so our assumption holds.
         *
         * We'll decrement count when we find an odd which isn't prime.
         *
         * If n = 3,  c = 1.
         * If n = 5,  c = 2.
         * If n = 10, c = 5.
         */
        int c = n / 2;

        /**
         * Java initializes boolean arrays to {false}.
         * In this method, we'll use truth to mark _composite_ numbers.
         *
         * This is the opposite of most Sieve of Eratosthenes methods,
         * which use truth to mark _prime_ numbers.
         *
         * We will _NOT_ mark evens as composite, even though they are.
         * This is because `c` is current after each `i` iteration below.
         */
        boolean[] s = new boolean[n];

        /**
         * Starting with an odd prime-candidate above 2, increment by two
         * to skip evens (which we know are not prime candidates).
         */
        for (int i = 3; i * i < n; i += 2) {
            if (s[i]) continue;  // c has already bean decremented for this composite odd
        }
    }
}