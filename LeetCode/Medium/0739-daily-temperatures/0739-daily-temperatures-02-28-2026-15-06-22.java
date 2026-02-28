class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>(); //stores indexes of monotonic decreasing temperature
        int[] result = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                int index = stack.pop();
                result[index]=i-index;
            }
            stack.push(i);
        }
        return result;
    }
}