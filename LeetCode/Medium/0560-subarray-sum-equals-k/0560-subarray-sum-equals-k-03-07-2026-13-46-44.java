// map : sum -> count of seeing this sum before
// put in map (0,1) 
// prefixSum=0,count=0
// for(i to n){  
//     prefixSum+=nums[i]
//     if(maps.containsKey(nums[j]-k)){  
//         count+=map.get(nums[j]-k);
//     }
//     map.put(i,map.getOrDefault(i,0)+1)
// }
// return count
// nums[j]-nums[i]=k  => nums[j] - k = nums[i]

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1); 
        int prefixSum = 0, count = 0;
        for(int num:nums){
            prefixSum+=num; 
            if(map.containsKey(prefixSum-k)){
                count+=map.get(prefixSum-k); 
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1); 
        }
        return count; 
    }
}