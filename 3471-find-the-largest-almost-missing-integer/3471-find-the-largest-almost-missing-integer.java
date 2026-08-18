class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] windows = new int[51];          
        for (int i = 0; i + k <= n; i++) {
            boolean[] seen = new boolean[51]; 
            for (int j = i; j < i + k; j++) {
                if (!seen[nums[j]]) {
                    seen[nums[j]] = true;
                    windows[nums[j]]++;
                }
            }
        }
        for (int v = 50; v >= 0; v--) {
            if (windows[v] == 1) return v;
        }
        return -1;
    }
}