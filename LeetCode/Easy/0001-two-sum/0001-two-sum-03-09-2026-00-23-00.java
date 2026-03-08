class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> diffSeenBefore = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int difference = target-nums[i];
            if(diffSeenBefore.containsKey(difference)){
                return new int[]{i,diffSeenBefore.get(difference)};
            }
            diffSeenBefore.put(nums[i],i);
        }
        return new int[]{};
    }
}