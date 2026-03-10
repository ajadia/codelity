package org.example.dsa.utility;

import java.util.concurrent.Semaphore;

public class ZeroEvenOdd {

    private int n;
    private final Semaphore zeroSemaphore = new Semaphore(1);
    private final Semaphore oddSemaphore = new Semaphore(0);
    private final Semaphore evenSemaphore = new Semaphore(0);


    private final StringBuilder zeroOutput = new StringBuilder();
    private final StringBuilder oddOutput = new StringBuilder();
    private final StringBuilder evenOutput = new StringBuilder();
    private final StringBuilder sequence = new StringBuilder();


    public ZeroEvenOdd(int n) {
        this.n = n;
    }


    public void zero() {
        try {
            for (int i = 1; i <= n; i++) {
                zeroSemaphore.acquire();

                zeroOutput.append("0");
                sequence.append("0 ");

                if (i % 2 == 1) {
                    oddSemaphore.release();
                } else {
                    evenSemaphore.release();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public void odd() {
        try {
            for (int i = 1; i <= n; i += 2) {
                oddSemaphore.acquire();

                oddOutput.append(i);
                sequence.append(i).append(" ");

                zeroSemaphore.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void even() {
        try {
            for (int i = 2; i <= n; i += 2) {
                evenSemaphore.acquire();

                evenOutput.append(i);
                sequence.append(i).append(" ");

                zeroSemaphore.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void printOutputs() {
        System.out.println("Sequence: " + sequence.toString().trim());
        System.out.println("(T1) Zero : " + zeroOutput.toString());
        System.out.println("(T2) Odd : " + oddOutput.toString());
        System.out.println("(T3) Even: " + evenOutput.toString());

    }
}
