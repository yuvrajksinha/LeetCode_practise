//binary search on answer
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1, max = 1;
        for(int pile:piles){
            max = Math.max(max,pile);
        }
        int right = max,rate = 0;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(canEat(piles,mid,h)){
                rate = mid; //4
                right=mid-1; //3
            } else {
                left=mid+1; //4
            }
        }
        return rate;
    }
    public boolean canEat(int[] piles,int rate, int h){
        int totalTime=0;
        for(int pile:piles){
            // totalTime += Math.ceil((double) pile/rate); //1+2+2+3=8
            totalTime+=(pile+rate-1)/rate;
            if(totalTime>h){
                return false;
            }
        }
        return true; //8<=8(true)
    }
}