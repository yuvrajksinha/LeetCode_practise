class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();//stores indexes of monotonic decreasing temperature
        int[] result = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                int prevIndex = stack.pop();
                result[prevIndex]=i-prevIndex;
            }
            stack.push(i);
        }
        return result;
    }
}