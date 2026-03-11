package org.example.corejava.strings;

public class CountCharacterFrequency {
    public static void main(String[] args) {
        String input = "hello";
        countCharacterFrequency(input);
    }

    private static void countCharacterFrequency(String str) {
        if (str == null) {
            System.out.println("Input string is null.");
            return;
        }
        String cleaned = str.replaceAll("\\s", "").toLowerCase();
        int[] frequency = new int[36]; // 26 letters + 10 digits

        for (char c : cleaned.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                frequency[c - 'a']++;
            } else if (c >= '0' && c <= '9') {
                frequency[26 + (c - '0')]++;
            }
        }

        System.out.println("Character Frequency:");
        for (int i = 0; i < frequency.length; i++) { // Fixed length cout
            if (frequency[i] > 0) {
                char ch = (i < 26) ? (char) ('a' + i) : (char) ('0' + (i - 26));
                System.out.println(ch + ": " + frequency[i]);
            }
        }
    }
}
