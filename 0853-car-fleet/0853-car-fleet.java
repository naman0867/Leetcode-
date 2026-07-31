import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 1) return 1;

        int[][] combine = new int[n][2];
        for (int i = 0; i < n; i++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }
        Arrays.sort(combine, Comparator.comparingInt(o -> o[0]));

        Stack<Double> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            double currTime = (double)(target - combine[i][0]) / combine[i][1];
            if (!stack.isEmpty() && currTime <= stack.peek()) {
                continue;
            }
            stack.push(currTime);
        }
        return stack.size();
    }
}