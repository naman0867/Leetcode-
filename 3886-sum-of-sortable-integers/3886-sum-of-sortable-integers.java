class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int total = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            int prevMax = 0;
            boolean ok = true;

            for (int s = 0; s < n && ok; s += k) {
                int descents = 0;
                int pos = -1;

                for (int i = 0; i < k; i++) {
                    int cur = nums[s + i];
                    int nxt = nums[s + (i + 1) % k];
                    if (cur > nxt) {
                        descents++;
                        pos = i;
                        if (descents > 1) break;
                    }
                }

                if (descents > 1) {
                    ok = false;
                    break;
                }

                int lo, hi;
                if (descents == 0) {
                    lo = hi = nums[s];
                } else {
                    lo = nums[s + (pos + 1) % k];
                    hi = nums[s + pos];
                }

                if (lo < prevMax) {
                    ok = false;
                    break;
                }
                prevMax = hi;
            }

            if (ok) total += k;
        }

        return total;
    }
}