class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int total = 0;
        for (int i = 0; i < n; i++) if (s.charAt(i) == '1') total++;

    
        List<int[]> runsList = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            runsList.add(new int[]{s.charAt(i) - '0', i, j - 1});
            i = j;
        }
        int m = runsList.size();
        int[][] runs = runsList.toArray(new int[0][]);

        int[] rid = new int[n];
        for (int k = 0; k < m; k++)
            for (int p = runs[k][1]; p <= runs[k][2]; p++) rid[p] = k;


        int[] gain = new int[m];
        for (int k = 0; k + 2 < m; k++) {
            if (runs[k][0] == 0 && runs[k + 2][0] == 0)
                gain[k] = (runs[k][2] - runs[k][1] + 1) + (runs[k + 2][2] - runs[k + 2][1] + 1);
        }

        int LOG = Math.max(1, 32 - Integer.numberOfLeadingZeros(m));
        int[][] sp = new int[LOG][];
        sp[0] = gain;
        for (int p = 1; p < LOG; p++) {
            int size = 1 << p, half = 1 << (p - 1);
            int len = m - size + 1;
            if (len <= 0) { sp[p] = new int[0]; continue; }
            sp[p] = new int[len];
            for (int x = 0; x < len; x++)
                sp[p][x] = Math.max(sp[p - 1][x], sp[p - 1][x + half]);
        }

        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            int a = rid[l], b = rid[r];
            if (a == b) { ans.add(total); continue; }

            int best = 0;
            if (b - 3 >= a + 1) best = rmq(sp, a + 1, b - 3);

            if (a + 2 <= b && runs[a][0] == 0 && runs[a + 2][0] == 0)
                best = Math.max(best, clip(runs[a], l, r) + clip(runs[a + 2], l, r));
            if (b - 2 >= a && runs[b][0] == 0 && runs[b - 2][0] == 0)
                best = Math.max(best, clip(runs[b], l, r) + clip(runs[b - 2], l, r));

            ans.add(total + best);
        }
        return ans;
    }

    private int clip(int[] run, int l, int r) {
        return Math.min(run[2], r) - Math.max(run[1], l) + 1;
    }

    private int rmq(int[][] sp, int lo, int hi) {
        if (lo > hi) return 0;
        int p = 31 - Integer.numberOfLeadingZeros(hi - lo + 1);
        return Math.max(sp[p][lo], sp[p][hi - (1 << p) + 1]);
    }
}