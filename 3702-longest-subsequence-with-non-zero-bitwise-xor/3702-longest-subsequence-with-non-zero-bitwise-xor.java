class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int XOR = 0;
        boolean allZero = true;
        for(int v : nums){
            XOR^= v ;
if(v!=0) allZero = false;
        }
        if(XOR!=0)  return n;
        return allZero? 0 : n-1;

    }
}