package org.example.corejava.strings;

/*
A palindrome string is a sequence of characters, words, or numbers that reads exactly the same forward and backward, ignoring spaces, punctuation, and capitalization.
 */

public class CheckPalindrome {
    public static void main(String[] args) {
        String input1 = "A man, a plan, a canal, Panama";
        /*String input2 = "Hellolleh";
        String input3 = "Not a palindrome";*/
        boolean isPalindrome = checkPalindrome(input1);
        System.out.println("Is the input a palindrome? " + isPalindrome);
    }

    private static boolean checkPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanedInput.length() - 1;

        while (left < right) {
            if (cleanedInput.charAt(left) != cleanedInput.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
