class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;

        
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int k = n - 2; k >= 0; k--) {
            suffixMin[k] = Math.min(suffixMin[k + 1], nums[k]);
        }

        int ans = Integer.MAX_VALUE;
        int prefixMin = nums[0];

        for (int j = 1; j < n - 1; j++) {
            int rightMin = suffixMin[j + 1];
            if (prefixMin < nums[j] && rightMin < nums[j]) {
                ans = Math.min(ans, prefixMin + nums[j] + rightMin);
            }
            prefixMin = Math.min(prefixMin, nums[j]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}