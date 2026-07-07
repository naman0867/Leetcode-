class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        
        
        char[] minSuffix = new char[n + 1];
        minSuffix[n] = Character.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            minSuffix[i] = (char) Math.min(s.charAt(i), minSuffix[i + 1]);
        }
        
        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            stack.push(s.charAt(i));
            
            while (!stack.isEmpty() && stack.peek() <= minSuffix[i + 1]) {
                result.append(stack.pop());
            }
        }
      
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.toString();
    }
}