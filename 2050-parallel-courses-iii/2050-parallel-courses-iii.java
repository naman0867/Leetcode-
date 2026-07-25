class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        int[] indegree = new int[n+1];
        for(int[] r:relations){
            graph.get(r[0]).add(r[1]);
            indegree[r[1]]++;
        }
        int[] finish = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i] == 0){
                finish[i] = time[i-1];
                queue.offer(i);
            }

        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next:graph.get(cur)){
                finish[next] = Math.max(finish[next],finish[cur]+time[next-1]);
                if(--indegree[next] == 0){
                    queue.offer(next);
                }
            }    
                }
                int ans = 0;
                for(int  i=1;i<=n;i++) ans = Math.max(ans,finish[i]);
                return ans;
    }
}