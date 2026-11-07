
import java.util.*;

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int[] edge : relations) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                dp[i] = time[i - 1];
            }
        }

        int ans = 0;

        while (!queue.isEmpty()) {

            int u = queue.poll();

            ans = Math.max(ans, dp[u]);

            for (int v : adj.get(u)) {

                
                dp[v] = Math.max(dp[v], dp[u] + time[v - 1]);

                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return ans;
    }
}
