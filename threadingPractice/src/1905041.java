//Complete the following Java code that finds the total number of prime numbers from a 100000 random integers array using an array of 10 threads in parallel. You cannot write any more classes.

import java.util.Random;

class ParallelPrimeCounter implements Runnable {
    private int[] numbers;
    private int startIndex;
    private static final int NUMBER_COUNT = 10000;
    private int primeCount;
    // you are not allowed to add any more fields

    // you are not allowed to change this constructor, and you are not allowed to add any more constructor
    ParallelPrimeCounter(int[] numbers, int startIndex) {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.primeCount = 0;
    }

    // your code here
    @Override
    public void run() {

        countPrime();
    }

    public int getPrimeCount() {
        return primeCount;
    }

    private void countPrime() {
        for (int numArrayIdx = startIndex, idx = 0; idx < NUMBER_COUNT; idx++, numArrayIdx++ ) {
            if (isPrime(numbers[numArrayIdx])) {
                primeCount++;
            }
        }
    }

    private boolean isPrime( int numberToBeChecked ) {
        if (numberToBeChecked <= 1) {
            return false;
        } else if (numberToBeChecked == 2) {
            return true;
        } else if ( numberToBeChecked % 2 == 0 ) {
            return false;
        } else {
            for (int divisor = 3; divisor * divisor <= numberToBeChecked; divisor += 2) {
                if (numberToBeChecked % divisor == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        final int NUMBER_COUNT = 100000;
        final int THREAD_COUNT = 10;
        int[] numbers = new int[NUMBER_COUNT];
        for (int i = 0; i < numbers.length; i++) {
            //numbers[i] = random.nextInt();
            numbers[i] = i+1;
        }
        ParallelPrimeCounter[] parallelPrimeCounters = new ParallelPrimeCounter[THREAD_COUNT];
        Thread[] threads = new Thread[THREAD_COUNT];
        // your code here

        for (int idx = 0, startIdx = 0; idx < THREAD_COUNT; idx++, startIdx += NUMBER_COUNT / THREAD_COUNT ) {
            parallelPrimeCounters[idx] = new ParallelPrimeCounter(numbers, startIdx);
        }

        for (int idx = 0; idx < THREAD_COUNT; idx++) {

            threads[idx] = new Thread(parallelPrimeCounters[idx]);
            threads[idx].start();
        }

        /**/

        boolean isAllDead = false;
        while (!isAllDead) {
            int aliveCount = 0;
            for (int idx = 0; idx < THREAD_COUNT; idx++) {
                if (threads[idx].isAlive()) {
                    aliveCount++;
                }
            }
            if (aliveCount == 0) {
                int totalPrime = 0;

                for (int i = 0; i < THREAD_COUNT; i++ ) {
                    //System.out.println(threads[i].getName() + " primes:" + parallelPrimeCounters[i].getPrimeCount());
                    totalPrime += parallelPrimeCounters[i].getPrimeCount();
                }
                System.out.println("Total number of primes " + totalPrime);
                isAllDead = true;
            }
        }

    }
}