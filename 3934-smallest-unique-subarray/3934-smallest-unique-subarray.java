import java.util.Arrays;
import java.util.Random;

class Solution {
    private static final long M1 = 1_000_000_007L;
    private static final long M2 = 998_244_353L;

    private long b1, b2;
    private int[] nums;

    public int smallestUniqueSubarray(int[] nums) {
        this.nums = nums;
        Random rnd = new Random();
        b1 = 100_003 + rnd.nextInt(900_000_000);
        b2 = 100_003 + rnd.nextInt(800_000_000);

        int lo = 1, hi = nums.length, ans = nums.length;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (hasUnique(mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private boolean hasUnique(int len) {
        int n = nums.length;
        int cnt = n - len + 1;

        long p1 = 1, p2 = 1; // base^len
        for (int i = 0; i < len; i++) {
            p1 = p1 * b1 % M1;
            p2 = p2 * b2 % M2;
        }

        long[] keys = new long[cnt];
        long h1 = 0, h2 = 0;
        for (int i = 0; i < len; i++) {
            h1 = (h1 * b1 + nums[i]) % M1;
            h2 = (h2 * b2 + nums[i]) % M2;
        }
        keys[0] = h1 * M2 + h2;

        for (int i = len; i < n; i++) {
            h1 = ((h1 * b1 + nums[i] - nums[i - len] * p1) % M1 + M1) % M1;
            h2 = ((h2 * b2 + nums[i] - nums[i - len] * p2) % M2 + M2) % M2;
            keys[i - len + 1] = h1 * M2 + h2;
        }

        Arrays.sort(keys);
        for (int i = 0; i < cnt; i++) {
            boolean samePrev = i > 0 && keys[i] == keys[i - 1];
            boolean sameNext = i + 1 < cnt && keys[i] == keys[i + 1];
            if (!samePrev && !sameNext) return true;
        }
        return false;
    }
}