class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for(int i=0;i<n;i++){
            cars[i][0] = position[i];
          cars[i][1] = speed[i];
        }
        Arrays.sort(cars,Comparator.comparingInt(o->o[0]));

        Stack<Double> stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            double time = (double) (target-cars[i][0]) / cars[i][1];

            if(stack.isEmpty() || time>stack.peek()){
                stack.push(time);
            }
        }
        return stack.size();
    }
}