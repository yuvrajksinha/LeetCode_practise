class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n && nums[i]<=0;i++){
            int left = i+1, right = n-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    result.add(List.of(nums[i],nums[left++],nums[right--]));
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                } else if(sum<0){
                    left++;
                } else {
                    right--;
                }
            } 
        }
        return new ArrayList<>(result);
    }
}