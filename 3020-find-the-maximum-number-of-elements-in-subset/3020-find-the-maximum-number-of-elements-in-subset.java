import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> count = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            count.put((long) num, count.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        // Special case for 1
        if (count.containsKey(1L)) {
            int ones = count.get(1L);
            ans = Math.max(ans, (ones % 2 == 0) ? ones - 1 : ones);
        }

        // Try every number as starting point
        for (long x : count.keySet()) {
            if (x == 1) continue;

            int len = 0;
            long curr = x;

            while (count.getOrDefault(curr, 0) >= 2) {
                len += 2;
                if (curr > 1e9) break; // prevent overflow
                curr = curr * curr;
            }

            if (count.getOrDefault(curr, 0) >= 1) {
                len += 1;
            } else {
                len -= 1;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}