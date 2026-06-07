class Solution {
    public int trap(int[] height) {
        //monotonic decreasing stack
        Deque<Integer> stack = new ArrayDeque<>();
        int water=0;
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty() && height[stack.peek()]<height[i]){
                int bottom = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int rightWall=i;
                int leftWall=stack.peek();

                int length=Math.min(height[leftWall],height[rightWall])-height[bottom];
                int width=rightWall-leftWall-1;

                water+=(length*width);
            }
            stack.push(i);
        }
        return water;
    }
}