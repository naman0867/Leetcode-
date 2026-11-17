class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        final int INF = 1_000_000;
        char[] c = s.toCharArray();

        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int len = j - i + 1;
                if (len == 1) {
                    cost[i][j] = INF;
                    continue;
                }
                int best = INF;
                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;
                    int changes = 0;
                    int groupSize = len / d;
                    for (int r = 0; r < d; r++) {
                        int l = i + r;
                        int rr = i + r + (groupSize - 1) * d;
                        while (l < rr) {
                            if (c[l] != c[rr]) changes++;
                            l += d;
                            rr -= d;
                        }
                    }
                    best = Math.min(best, changes);
                }
                cost[i][j] = best;
            }
        }

       
        int[][] dp = new int[k + 1][n + 1];
        for (int[] row : dp) java.util.Arrays.fill(row, INF);
        dp[0][0] = 0;

        for (int p = 1; p <= k; p++) {
            for (int i = 2 * p; i <= n; i++) { 
                for (int m = 2 * (p - 1); m <= i - 2; m++) {
                    if (dp[p - 1][m] >= INF) continue;
                    dp[p][i] = Math.min(dp[p][i], dp[p - 1][m] + cost[m][i - 1]);
                }
            }
        }
        return dp[k][n];
    }
}