class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] b  = new int[n];

        for(int i=0;i<n;i++) b[i] = nums[n-1-i];
        int[] dq = new int[n];
        int head = 0,tail =0;
        long sumMax = 0,sumB = 0;
        long ans = 0;
        int L = 0;
        for(int R = 0;R<n;R++){
            while(tail > head && b[dq[tail - 1]] < b[R]){
                int j = dq[tail - 1];
                int prev = (tail - 1 > head) ? dq[tail - 2] : L - 1;
                sumMax -= (long) (j - prev) * b[j];
                tail --;
            }
            int prev = (tail > head) ? dq[tail -1] : L-1;
            sumMax += (long) (R - prev) * b[R];
            dq[tail++] = R;
            sumB += b[R];

            while(sumMax - sumB > k){
                sumMax -= b[dq[head]];
                sumB -= b[L];
                if(dq[head] == L) head++;
                L++;
            }
             ans += R-L + 1;

        }
        return ans;
    }
}