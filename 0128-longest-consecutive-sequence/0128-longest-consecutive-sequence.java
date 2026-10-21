class Solution {
    public int longestConsecutive(int[] nums) {
        Set <Integer> h = new HashSet<>();
        for(int x : nums)
        h.add(x);
        int res = 0;
        for(Integer x : h)
        if(h.contains(x-1) == false){
            int curr = 1;
            while(h.contains(x + curr))
            curr++;
            res = Math.max(res,curr);
        }
        return res;
    }
}