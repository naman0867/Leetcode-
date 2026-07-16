class Solution {
    public int countBinarySubstrings(String s) {
        int prev = 0, cur = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                count += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            }
        }
        count += Math.min(prev, cur);
        return count;
    }
}