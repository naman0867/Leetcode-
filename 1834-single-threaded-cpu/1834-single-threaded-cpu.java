
import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

 
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int[] ans = new int[n];
        int idx = 0;
        int count = 0;

        long time = 0;

        while (count < n) {

           
            while (idx < n && arr[idx][0] <= time) {
                pq.offer(new int[]{arr[idx][1], arr[idx][2]});
                idx++;
            }

           
            if (pq.isEmpty()) {
                time = Math.max(time, arr[idx][0]);
                continue;
            }

            int[] curr = pq.poll();

            ans[count++] = curr[1];

            time += curr[0];
        }

        return ans;
    }
}
