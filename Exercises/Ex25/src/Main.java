public class Main {
    public static void main(String[] args) {
        System.out.println(getLargestPrime(7));
    }

//    Write a method named getLargestPrime with one parameter of type int named number.
//    If the number is negative or does not have any prime numbers, the method should return -1 to indicate an invalid value.
//    The method should calculate the largest prime factor of a given number and return it.

    public static int getLargestPrime(int num) {
        if (num <= 1) {
            return -1;
        }
        int largestPrime = 1;
        for (int i = 2; i <= num; i++) {
            boolean isPrime = true;
            for (int y = 2; y < i; y++) {
                if (i % y == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && num % i == 0) {
                largestPrime = i;
            }
        }
        if (largestPrime == 1) {
            return -1;
        }
        return largestPrime;
    }
}