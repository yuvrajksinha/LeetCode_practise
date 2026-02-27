class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> remainders = new HashMap<>();
        remainders.put(0,-1);
        int prefixSum=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            int remainder = prefixSum%k;
            if(remainders.containsKey(remainder)){
                if(i-remainders.get(remainder)>=2){
                    return true;
                }
            } else {
                remainders.put(remainder,i);
            }
        }
        return false;
    }
}