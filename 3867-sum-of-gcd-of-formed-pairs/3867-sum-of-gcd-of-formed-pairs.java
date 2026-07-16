class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] p = new int[n];
        int mx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > mx) mx = nums[i];
            p[i] = gcd(nums[i], mx);
        }
        java.util.Arrays.sort(p);
        long sum = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            sum += gcd(p[l], p[r]);
            l++;
            r--;
        }
        return sum;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}