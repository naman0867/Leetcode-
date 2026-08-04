class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        boolean[] present = new boolean[101];
        int lo = 101,hi= 0;
        for(int x : nums){
            present[x] = true;
            lo  =   Math.min(lo,x);
            hi = Math.max(hi,x);
        }
        List <Integer> ans = new ArrayList<>();
        for(int x = lo+1;x<hi;x++){
            if(!present[x]) ans.add(x);
        }
        return ans;
    }
}