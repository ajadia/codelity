package org.example.corejava.strings;
/*
* An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once. For example, "listen" and "silent" are anagrams of each other.
* */

public class CheckAnagram {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        boolean isAnagram = checkAnagram(str1, str2);
        System.out.println("Are the two strings anagrams? " + isAnagram);
    }

    private static boolean checkAnagram(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        String cleanedStr1 = str1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String cleanedStr2 = str2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanedStr1.length() != cleanedStr2.length()) {
            return false;
        }

        int[] charCount = new int[26];
        for (int i = 0; i < cleanedStr1.length(); i++) {
            charCount[cleanedStr1.charAt(i) - 'a']++; // Increment count for first string
            charCount[cleanedStr2.charAt(i) - 'a']--; // Decrement count for second string
        }
        for (int count : charCount) { // constant time complexity O(1) as we are checking only 26 characters
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
