class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        int[][] cars = new int[n][2];
        for(int i=0;i<n;i++){
            cars[i][0]=position[i];
            cars[i][1]=speed[i];
        }
        Arrays.sort(cars,(a,b)->b[0]-a[0]); //descending order
        Deque<Double> stack = new ArrayDeque<>();
        for(int[] car:cars){
            int p=car[0];
            int s=car[1];
            double totalTimeTaken=(double) (target-p)/s;
            if(stack.isEmpty() || totalTimeTaken>stack.peek()){
                stack.push(totalTimeTaken);
            }
        }
        return stack.size();
    }
}