class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        for(int cookies : s){
            if(i<g.length && cookies>=g[i]){
                i++;
            }
        }
        return i;
    }
}