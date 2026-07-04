class Solution {
    private int[] parent;
    private int find(int x){
        while(parent[x]!=x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
return x;
    }
    private void union(int a, int b){
        int ra = find(a), rb = find(b);
        if(ra!=rb) parent[ra] = parent[rb];
    }
    public int minScore(int n, int[][] roads) {
        parent = new int[n+1];
        for(int i=0;i<=n;i++) parent[i] = i;
        for(int[]r : roads) union(r[0],r[1]);
        int root = find(1);
        int ans = Integer.MAX_VALUE;
        for(int[] r: roads){
            if(find(r[0])==root){
                ans = Math.min(ans,r[2]);
            }
        }
        return ans;
    }
}