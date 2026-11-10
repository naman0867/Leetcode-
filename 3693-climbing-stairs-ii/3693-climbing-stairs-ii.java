class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int j=1;j<=n;j++){
            int best = Integer.MAX_VALUE;
            for(int k=1;k<=3 && j-k>=0;k++){
                best = Math.min(best,dp[j-k]+costs[j-1]+k*k);
            }
            dp[j] = best;
        }
        return dp[n];
    }
}