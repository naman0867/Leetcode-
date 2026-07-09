class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] comp = new int[n];
        for(int i=1;i<n;i++){
            comp[i] = comp[i-1]+(nums[i]-nums[i-1]>maxDiff?1:0);

        }
        boolean[] answer = new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            answer[i] = comp[queries[i][0]] == comp[queries[i][1]];
        }
        return answer;
    }
}