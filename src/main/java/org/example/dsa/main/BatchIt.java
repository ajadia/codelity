package org.example.dsa.main;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class BatchIt {

 /*
  * / Input: Stream of 1,2,3,4,5,6,7,8,9,10 with batchSize=3
    / Output: [[1,2,3], [4,5,6], [7,8,9], [10]]

    public static <T> Collector<T, ?, List<List<T>>> batching(int batchSize) {
        // Implement this custom collector
    }
  *
    // Usage:
    List<List<Integer>> batches = Stream.of(1,2,3,4,5,6,7,8,9,10)
    .collect(batching(3));
* */


    public static void main(String[] args) {
        List<List<Integer>> batches = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(batching(3)
                );
        System.out.println(batches);
    }

    private static <T> Collector<Integer, ?, List<List<Integer>>> batching(int batchSize) {

        if (batchSize <= 0) {
            throw new IllegalArgumentException("Batch size must be a positive integer.");
        }
        class Accumulator {
            private List<List<Integer>> batches = new java.util.ArrayList<>();
            private List<Integer> currentBatch = new java.util.ArrayList<>();

            public void add(Integer number) {
                currentBatch.add(number);
                if (currentBatch.size() == batchSize) {
                    batches.add(new java.util.ArrayList<>(currentBatch));
                    currentBatch.clear();
                }
            }

            public Accumulator combine(Accumulator other) {
                if (!other.currentBatch.isEmpty()) {
                    batches.add(new java.util.ArrayList<>(other.currentBatch));
                }
                batches.addAll(other.batches);
                return this;
            }

            public List<List<Integer>> finish() {
                if (!currentBatch.isEmpty()) {
                    batches.add(new java.util.ArrayList<>(currentBatch));
                }
                return batches;
            }
        }
        return Collector.of(
                Accumulator::new,
                Accumulator::add,
                Accumulator::combine,
                Accumulator::finish
        );
    }
}
