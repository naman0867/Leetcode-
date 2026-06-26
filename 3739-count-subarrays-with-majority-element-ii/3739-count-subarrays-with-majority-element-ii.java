import java.util.*;

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] pre = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (nums[i] == target ? 1 : -1);
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int x : pre) set.add(x);

        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        for (int x : set) map.put(x, idx++);

        int[] bit = new int[idx + 1];
        long ans = 0;

        for (int x : pre) {
            int i = map.get(x);

            int t = i - 1;
            while (t > 0) {
                ans += bit[t];
                t -= t & -t;
            }

            while (i < bit.length) {
                bit[i]++;
                i += i & -i;
            }
        }

        return ans;
    }
}