class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++){
            int frq = 0;
            for(int j=i;j<n;j++){
                if(nums[j] == target) frq++;
                if(frq*2>j-i+1) count++;
            }
          
        }
          return count;
    }
}