class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
 
        int lo = 0, hi = price[n - 1] - price[0];
        int ans = 0;
 
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; 
            if (canPick(price, k, mid)) {
                ans = mid;      
                lo = mid + 1;
            } else {
                hi = mid - 1;   
            }
        }
        return ans;
    }
 
  
    private boolean canPick(int[] price, int k, int gap) {
        int count = 1;              
        int lastPicked = price[0];
 
        for (int i = 1; i < price.length && count < k; i++) {
            if (price[i] - lastPicked >= gap) {
                count++;
                lastPicked = price[i];
            }
        }
        return count >= k;
    }
}