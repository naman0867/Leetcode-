class Solution {
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return res;

        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for (int c = 0; c < n; c++) {
            dfs(heights, 0, c, pac);       
            dfs(heights, m - 1, c, atl);    
        }
        for (int r = 0; r < m; r++) {
            dfs(heights, r, 0, pac);       
            dfs(heights, r, n - 1, atl);    
        }

        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                if (pac[r][c] && atl[r][c])
                    res.add(Arrays.asList(r, c));
        return res;
    }

    private void dfs(int[][] h, int r, int c, boolean[][] seen) {
        seen[r][c] = true;
        for (int[] d : DIRS) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < h.length && nc >= 0 && nc < h[0].length
                    && !seen[nr][nc] && h[nr][nc] >= h[r][c]) {
                dfs(h, nr, nc, seen);
            }
        }
    }
}