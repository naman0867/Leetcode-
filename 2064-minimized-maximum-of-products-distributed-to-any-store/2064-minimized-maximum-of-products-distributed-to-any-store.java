class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int lo = 1, hi = 0;
        for (int q : quantities) hi = Math.max(hi, q);

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (feasible(mid, n, quantities)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean feasible(int x, int n, int[] quantities) {
        long stores = 0;
        for (int q : quantities) {
            stores += (q + x - 1) / x;   // ceil(q / x)
            if (stores > n) return false; // early exit
        }
        return true;
    }
}