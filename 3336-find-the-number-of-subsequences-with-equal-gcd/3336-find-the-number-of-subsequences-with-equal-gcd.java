class Solution {
    public int subsequencePairCount(int[] nums) {
        final int MOD = 1_000_000_007;
        int maxNum = Arrays.stream(nums).max().getAsInt();
    
        int[][] dp = new int[maxNum + 1][maxNum + 1];
        dp[0][0] = 1;

        for (int num : nums) {
            int[][] newDp = new int[maxNum + 1][maxNum + 1];
            for (int x = 0; x <= maxNum; x++) {
                for (int y = 0; y <= maxNum; y++) {
                    if (dp[x][y] == 0) continue;
            
                    newDp[x][y] = (newDp[x][y] + dp[x][y]) % MOD;
                    
                    int newX = gcd(x, num);
                    newDp[newX][y] = (newDp[newX][y] + dp[x][y]) % MOD;
                
                    int newY = gcd(y, num);
                    newDp[x][newY] = (newDp[x][newY] + dp[x][y]) % MOD;
                }
            }
            dp = newDp;
        }

        int ans = 0;
        for (int g = 1; g <= maxNum; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}