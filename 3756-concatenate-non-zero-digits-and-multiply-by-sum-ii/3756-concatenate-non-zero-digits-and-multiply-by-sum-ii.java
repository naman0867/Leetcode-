class Solution {
    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
         int m = s.length();
        long[] val = new long[m + 1];   
        long[] dsum = new long[m + 1]; 
        int[] cnt = new int[m + 1];     
        long[] pow10 = new long[m + 1];

           pow10[0] = 1;
        for (int i = 1; i <= m; i++) pow10[i] = pow10[i - 1] * 10 % MOD;

        for (int i = 0; i < m; i++) {
            int d = s.charAt(i) - '0';
            dsum[i + 1] = dsum[i] + d;
            if (d != 0) {
                val[i + 1] = (val[i] * 10 + d) % MOD;
                cnt[i + 1] = cnt[i] + 1;
            } else {
                val[i + 1] = val[i];
                cnt[i + 1] = cnt[i];
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            int k = cnt[r + 1] - cnt[l];
            long x = (val[r + 1] - val[l] * pow10[k]) % MOD;
            if (x < 0) x += MOD;
            long sum = (dsum[r + 1] - dsum[l]) % MOD;
            ans[i] = (int) (x * sum % MOD);
        }
        return ans;
    }
}
