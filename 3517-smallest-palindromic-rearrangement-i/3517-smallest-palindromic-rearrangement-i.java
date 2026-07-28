class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;

        char[] half = new char[n / 2];
        int idx = 0;
        char mid = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) mid = (char) ('a' + i);
            for (int j = 0; j < cnt[i] / 2; j++) {
                half[idx++] = (char) ('a' + i);
            }
        }
        

        StringBuilder sb = new StringBuilder();
        sb.append(half);
        if (n % 2 == 1) sb.append(mid);
        sb.append(new StringBuilder(new String(half)).reverse());
        return sb.toString();
    }
}