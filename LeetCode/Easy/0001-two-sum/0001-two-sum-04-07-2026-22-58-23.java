class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> seenBefore = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];
            if(seenBefore.containsKey(diff)){
                return new int[]{i,seenBefore.get(diff)};
            }
            seenBefore.put(nums[i],i);
        }
        return new int[]{};
    }
}