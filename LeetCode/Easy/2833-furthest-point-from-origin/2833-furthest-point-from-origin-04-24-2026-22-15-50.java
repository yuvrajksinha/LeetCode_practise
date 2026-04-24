class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int lCount = 0,rCount = 0,dCount = 0;
        for(char move:moves.toCharArray()){
            if(move=='L'){
                lCount++;
            } else if(move=='R'){
                rCount++;
            } else {
                dCount++;
            }
        }
        return Math.abs(lCount-rCount)+dCount;
    }
}