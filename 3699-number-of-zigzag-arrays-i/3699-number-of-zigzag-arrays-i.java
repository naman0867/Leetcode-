class Solution {
    public int zigZagArrays(int n, int l, int r) {
        final int MOD = 1_000_000_007;
        int m = r-l+1;
        long[][] dp = new long[m][2];
        long[] pre = new long[m+1];
        for(int v=0;v<m;v++) pre[v+1] = v+1;
        for(int v=0;v<m;v++) {
            dp[v][0] = pre[v];
            dp[v][1] = (pre[m]-pre[v+1]+MOD) % MOD;

        } 
        for(int step = 2;step<n; step++){
            long[] prefUp = new long[m+1], prefDn = new long[m+1];
            for (int v = 0; v < m; v++) {
                prefUp[v+1] = (prefUp[v] + dp[v][0]) % MOD;
                prefDn[v+1] = (prefDn[v] + dp[v][1]) % MOD;
        }
        long[][] ndp = new long[m][2];
            for (int w = 0; w < m; w++) {
                ndp[w][0] = prefDn[w];                             
                ndp[w][1] = (prefUp[m] - prefUp[w+1] + MOD) % MOD;
    }
    dp = ndp;

}
long ans = 0;
for(long[] d : dp) ans = (ans+d[0]+d[1])% MOD;
return (int) ans;
    }
}