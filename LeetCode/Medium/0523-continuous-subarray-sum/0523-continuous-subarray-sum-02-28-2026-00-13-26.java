// as we can tell from question we need prefixSum(till j) = nums[j] and prefixSum(till i)
// prefixSum(till j) - prefixSum(till i) is the sum of the subarray and that needs to be divisible 
// (nums[j]-nums[i])%k==0
// =>nums[j]%k-nums[i]%k==0 
// for this nums[j]%k==nums[i]%k
// so wherever the remainder of the prefixsum is equal 
//and we store the index of the remainders so we can check the length of j-i that give same remainder
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> remainders = new HashMap<>();
        remainders.put(0,-1); //prefixSum remainder 0 at index -1
        int prefixSumRemainder=0;
        for(int i=0;i<nums.length;i++){
            prefixSumRemainder = (prefixSumRemainder+nums[i])%k;
            if(remainders.containsKey(prefixSumRemainder)){
                if(i-remainders.get(prefixSumRemainder)>1){
                    return true;
                }
            } else {
                remainders.put(prefixSumRemainder,i);  //saving index for this sum remainder
            }                                          //not for every as we need max length
        }
        return false;
    }
}