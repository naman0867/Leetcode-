class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[4];

        for (int i = n - 1; i >= 0; i--) {
            int best = Integer.MIN_VALUE, take = 0;
            for (int k = 0; k < 3 && i + k < n; k++) {
                take += stoneValue[i + k];
                best = Math.max(best, take - dp[(i + k + 1) % 4]);
            }
            dp[i % 4] = best;
        }

        int r = dp[0];
        return r > 0 ? "Alice" : r < 0 ? "Bob" : "Tie";
    }
}