package org.example.dsa.main;

import org.example.dsa.utility.ZeroEvenOdd;

public class Test {
/*
    input -> integer (n)
    output -> sequence of numbers based on 'n'
    Example: n = 5
    sequence : 0 1 0 2 0 3 0 4 0 5
    3 threads -> T1, T2, T3
    T1 -> prints zeros in sequence
    T2 -> prints odd numbers
    T3 -> print even numbers
* */

    public static void main(String[] args) throws InterruptedException {
        int n = 6;
        if (n <= 0) {
            System.out.println("Input should be a positive integer.");
            return;
        }

        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);

        Thread t1 = new Thread(zeroEvenOdd::zero);
        Thread t2 = new Thread(zeroEvenOdd::odd);
        Thread t3 = new Thread(zeroEvenOdd::even);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        zeroEvenOdd.printOutputs();
    }
}
