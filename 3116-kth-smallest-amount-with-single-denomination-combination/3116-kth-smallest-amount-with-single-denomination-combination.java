class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length, size = 1 << n;

        long min = Integer.MAX_VALUE;
        for (int c : coins) min = Math.min(min, c);
        long lo = 1, hi = min * k;         

       
        long[] lcms = new long[size];
        lcms[0] = 1;
        for (int mask = 1; mask < size; mask++) {
            int low  = Integer.numberOfTrailingZeros(mask);
            int rest = mask & (mask - 1);
            lcms[mask] = Math.min(lcm(lcms[rest], coins[low]), hi + 1);
        }

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (count(lcms, n, mid) >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private long count(long[] lcms, int n, long x) {
        long total = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            long c = x / lcms[mask];
            if (c == 0) continue;
            total += (Integer.bitCount(mask) % 2 == 1) ? c : -c;
        }
        return total;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}