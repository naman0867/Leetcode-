class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxV = 0;
        for (int x : nums) maxV = Math.max(maxV, x);
        
        long[] cnt = new long[maxV + 1];
        for (int x : nums) cnt[x]++;
        

        long[] div = new long[maxV + 1];
        for (int g = 1; g <= maxV; g++) {
            long c = 0;
            for (int m = g; m <= maxV; m += g) c += cnt[m];
            div[g] = c;
        }
        
    
        long[] pairs = new long[maxV + 1];
        for (int g = maxV; g >= 1; g--) {
            long c = div[g];
            long total = c * (c - 1) / 2;
            for (int m = 2 * g; m <= maxV; m += g) total -= pairs[m];
            pairs[g] = total;
        }
        
    
        long[] prefix = new long[maxV + 1];
        prefix[0] = 0;
        for (int g = 1; g <= maxV; g++) prefix[g] = prefix[g - 1] + pairs[g];
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long q = queries[i] + 1;
            int lo = 1, hi = maxV, res = 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (prefix[mid] >= q) { res = mid; hi = mid - 1; }
                else lo = mid + 1;
            }
            ans[i] = res;
        }
        return ans;
    }
}