class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),subsets);
        return subsets;
    }
    public void backtrack(int[] nums,int index,List<Integer> subset,List<List<Integer>> subsets){
        subsets.add(new ArrayList<>(subset));
        for(int i=index;i<nums.length;i++){
            if(i!=index && nums[i]==nums[i-1]){ //if we have already backtracked for this number
                continue; //we don;t do it 
            }
            subset.add(nums[i]);
            backtrack(nums,i+1,subset,subsets);
            subset.remove(subset.size()-1);
        }
    }
}