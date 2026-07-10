import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> nums[a] - nums[b]);

        int[] pos = new int[n];      
        int[] sorted = new int[n];   
        for (int i = 0; i < n; i++) {
            pos[idx[i]] = i;
            sorted[i] = nums[idx[i]];
        }

        int LOG = 1;
        while ((1 << LOG) < n) LOG++;
        int[][] up = new int[LOG + 1][n];

    
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j < i) j = i;
            while (j + 1 < n && sorted[j + 1] - sorted[i] <= maxDiff) j++;
            up[0][i] = j;
        }
        for (int k = 1; k <= LOG; k++)
            for (int i = 0; i < n; i++)
                up[k][i] = up[k - 1][up[k - 1][i]];

        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int a = pos[queries[q][0]], b = pos[queries[q][1]];
            if (a > b) { int t = a; a = b; b = t; }

            if (a == b) { ans[q] = 0; continue; }
            if (up[0][a] >= b) { ans[q] = 1; continue; }

            int steps = 0, cur = a;
            for (int k = LOG; k >= 0; k--) {
                if (up[k][cur] < b) {         
                    steps += (1 << k);
                    cur = up[k][cur];
                }
            }
            ans[q] = (up[0][cur] >= b) ? steps + 1 : -1;
        }
        return ans;
    }
}