class Solution {
    public int largestRectangleArea(int[] heights) {
        int length=heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); //to denote end of stack
        int maxArea=0;
        for(int i=0;i<length;i++){
            while((stack.peek()!=-1) && heights[stack.peek()]>=heights[i]){
                int height = heights[stack.pop()];
                int width = i-stack.peek()-1;
                maxArea = Math.max(maxArea,height*width);
            }
            stack.push(i);
        }
        while(stack.peek()!=-1){
            int height = heights[stack.pop()];
            int width = length-stack.peek()-1;
            maxArea = Math.max(maxArea,height*width);
        }
        return maxArea;
    }
}