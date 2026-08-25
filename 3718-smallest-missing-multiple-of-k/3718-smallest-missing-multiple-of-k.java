class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        for (int x : nums) s.add(x);
        for (int i = 1; ; i++) {
            int x = k * i;
            if (!s.contains(x)) return x;
        }
    }
}