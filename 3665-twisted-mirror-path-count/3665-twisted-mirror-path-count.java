class Solution {
    public int uniquePaths(int[][] grid) {
        final int MOD = 1_000_000_007;
        int m = grid.length, n = grid[0].length;
        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 || dp[i][j] == 0) continue;
                long cnt = dp[i][j];

                // d = 0: move right, d = 1: move down
                for (int d = 0; d < 2; d++) {
                    int r = i, c = j, dir = d;
                    // step into the next cell in the current direction
                    if (dir == 0) c++; else r++;

                    while (r < m && c < n && grid[r][c] == 1) {
                        // mirror: deflect before entering
                        if (dir == 0) { // moving right -> turn down
                            r++;
                            dir = 1;
                        } else {        // moving down -> turn right
                            c++;
                            dir = 0;
                        }
                    }
                    if (r < m && c < n) {
                        dp[r][c] = (dp[r][c] + cnt) % MOD;
                    }
                }
            }
        }
        return (int) (dp[m - 1][n - 1] % MOD);
    }
}