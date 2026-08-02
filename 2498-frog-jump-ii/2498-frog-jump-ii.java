class Solution {
    public int maxJump(int[] stones) {
        int maxJumpDistance = stones[1]-stones[0];

        for(int i=2;i<stones.length;i++){
            int currentJumpDistance = stones[i]-stones[i-2];

            maxJumpDistance = Math.max(maxJumpDistance,currentJumpDistance);
         }
         return maxJumpDistance;
    }
}