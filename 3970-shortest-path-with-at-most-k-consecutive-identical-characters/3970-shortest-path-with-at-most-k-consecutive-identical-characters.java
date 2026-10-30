import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
     
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) g[e[0]].add(new int[]{e[1], e[2]});

        char[] c = labels.toCharArray();
        int W = k + 1; 
        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n * W];
        Arrays.fill(dist, INF);

     
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        dist[0 * W + 1] = 0;
        pq.offer(new long[]{0, 0, 1});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1], r = (int) cur[2];
            if (d > dist[u * W + r]) continue;
            if (u == n - 1) return (int) d;

            for (int[] e : g[u]) {
                int v = e[0];
                int nr = (c[u] == c[v]) ? r + 1 : 1;
                if (nr > k) continue;
                long nd = d + e[1];
                if (nd < dist[v * W + nr]) {
                    dist[v * W + nr] = nd;
                    pq.offer(new long[]{nd, v, nr});
                }
            }
        }
        return -1;
    }
}