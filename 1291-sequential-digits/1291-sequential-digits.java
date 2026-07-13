import java.util.*;
 
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= 9; i++) {
            q.offer(i);
        }
 
        while (!q.isEmpty()) {
            int num = q.poll();
 
            if (num >= low && num <= high) {
                result.add(num);
            }
 
            int lastDigit = num % 10;
           
            if (lastDigit < 9 && num <= high) {
                int next = num * 10 + (lastDigit + 1);
                q.offer(next);
            }
        }
 
        Collections.sort(result); 
        return result;
    }
}