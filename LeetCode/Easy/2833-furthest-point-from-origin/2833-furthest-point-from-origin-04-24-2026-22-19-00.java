class Solution {
    public int furthestDistanceFromOrigin(String moves) { //its only on the x-axis so no up and down
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
//so overall with all the given L and R we subtract one from the other to get the one that is more frequent (as we don't know about the more freq one we use Math.abs) then add the number of dashes as we keep going in that direction further away so whether it is L or R doesn't matter wo just move away so all the dashes count
    }
}