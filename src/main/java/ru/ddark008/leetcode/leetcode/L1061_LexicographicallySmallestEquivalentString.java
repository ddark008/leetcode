package ru.ddark008.leetcode.leetcode;

public class L1061_LexicographicallySmallestEquivalentString {
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] letters = new int[28];
        for(int i=0; i<letters.length; i++){
            letters[i]=i;
        }
        for(int i=0; i<s1.length(); i++){
            int ch1 = letters[s1.charAt(i) - 'a'];
            int ch2 = letters[s2.charAt(i) - 'a'];
            int m = Math.min(ch1, ch2);
            int r = Math.max(ch1, ch2);
            for(int j=0; j<letters.length; j++){
                if (letters[j]==r){
                    letters[j] = m;
                }
            }
        }
        char[] r = new char[baseStr.length()];
        for(int i=0; i<baseStr.length(); i++){
            int ch1 = baseStr.charAt(i) - 'a';
            r[i] = (char) (letters[ch1] + 'a');
        }
        return String.valueOf(r);
    }

    public static void main(String[] args) {
        System.out.println(smallestEquivalentString("hello", "world", "hold"));
    }
}
