class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=1,ans=1;
        for(int pile:piles){
            right=Math.max(right,pile);
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(rateOfEating(piles,h,mid)){
                ans = mid;
                right=mid-1;
            } else {
                left=mid+1;
            }
        }
        return ans;
    }
    public boolean rateOfEating(int[] piles,int h,int rate){
        int totalTime=0;
        for(int pile:piles){
            if(totalTime>h){
                return false;
            }
            totalTime+=(pile+rate-1)/rate;
        }
        return totalTime<=h;
    }
}