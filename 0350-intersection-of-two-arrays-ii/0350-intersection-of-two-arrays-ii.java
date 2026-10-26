import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1); // count the smaller array
        }
        Map<Integer, Integer> counts = new HashMap<>();
        for (int x : nums1) {
            counts.merge(x, 1, Integer::sum);
        }
        int[] res = new int[nums1.length];
        int k = 0;
        for (int x : nums2) {
            int c = counts.getOrDefault(x, 0);
            if (c > 0) {
                res[k++] = x;
                counts.put(x, c - 1);
            }
        }
        return Arrays.copyOf(res, k);
    }
}