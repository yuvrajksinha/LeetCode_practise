class Solution {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); //to denote end of stack but no null pointed
        int maxArea = 0;
        for(int i=0;i<length;i++){
            while((stack.peek()!=-1) && heights[stack.peek()]>=heights[i]){
                int height = heights[stack.pop()];
                int width = i-stack.peek()-1; //-1 is for the peek block area included
                maxArea = Math.max(maxArea, height*width);
            }
            stack.push(i);
        }
        while(stack.peek()!=-1){
            int height = heights[stack.pop()];
            int width = length-stack.peek()-1; //if peek is -1, -(-1)+1 cancels out 
            maxArea = Math.max(maxArea,height*width);
        }
        return maxArea;
    }
}