package basic_exercises;

public class Ex22PrimeNumbers {
    public static void main(String[] args) {
        int[] primes = new int[10];
        int i = 0;
        while (i < primes.length) {
            // if 0, 1 = not prime
            for (int j = 2; i < primes.length; j++) {
                boolean isPrime = true;
                for (int k = 2; k < j; k++) {
                    if (j % k == 0) {
                        //uhoh, not a prime!
                        isPrime = false;
                    }
                }
                if (isPrime) {
                    // found prime, store it.
                    primes[i] = j;
                    System.out.println(j);
                    i++;
                }
            }
        }
        System.out.println("Stored in primes array!");
    }
}
