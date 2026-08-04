class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return ans;
        dfs(s, 0, 0, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(String s, int start, int seg, StringBuilder path, List<String> ans) {
        if (seg == 4) {
            if (start == s.length()) ans.add(path.substring(0, path.length() - 1));
            return;
        }
        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            String part = s.substring(start, start + len);
            if (part.charAt(0) == '0' && len > 1) break;        
            if (len == 3 && Integer.parseInt(part) > 255) break; 
            int mark = path.length();
            path.append(part).append('.');
            dfs(s, start + len, seg + 1, path, ans);
            path.setLength(mark);                        
        }
    }
}