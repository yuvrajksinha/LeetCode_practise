class Solution {
    public int trap(int[] height) {
        // Monotonic decreasing stack: stores indices of bars
        Deque<Integer> stack = new ArrayDeque<>();
        int water=0;
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty() && height[stack.peek()]<height[i]){ //trapping water condition
                int bottom=stack.pop();// The 'floor' of the pit
                if(stack.isEmpty()){ // Need a left wall to hold water
                    break;
                }
                int rightWall=i; //the current greater height we have found in the right wall
                int leftWall=stack.peek(); //the previous greater wall than the current popped one

                // Horizontal Layer: fill water above the 'bottom' up to the lower wall
                int heightOfHorizontalArea = Math.min(height[leftWall],height[rightWall])-height[bottom]; 
                int widthOfHorizontalArea = rightWall-leftWall-1;

                water+=(heightOfHorizontalArea*widthOfHorizontalArea); //add the pit area to water
            }
            stack.push(i);//if the monotonic decrease is there keep it by pushing i
        }
        return water;
    }
}