class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,max=0;
        for(int pile:piles){
            max=Math.max(max,pile);
        }
        int right=max,ans=0;
        while(left<=right){
            int mid=left+(right-left)/2; 
            if(canEat(piles,mid,h)){
                ans=mid; 
                right=mid-1; 
            } else {
                left=mid+1;
            }
        }
        return ans;
    }
    public boolean canEat(int[] piles,int rate,int h){
        int totalTime=0;
        for(int pile:piles){
            totalTime+=(pile+rate-1)/rate; 
            if(totalTime>h){
                return false;
            }
        }
        return totalTime<=h; 
    }
}