class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backtracking(nums,new HashSet<>(),new ArrayList<>(),lists);
        return lists;
    }
    public void backtracking(int[] nums,Set<Integer> set,List<Integer> list,List<List<Integer>> lists){
        if(list.size()==nums.length){
            lists.add(new ArrayList<>(list)); 
        }
        for(int i=0;i<nums.length;i++){ 
            if(!set.contains(nums[i])){ 
                list.add(nums[i]); 
                set.add(nums[i]); //to not have any of the numbers we already have in the set repeat
                backtracking(nums,set,list,lists);
                set.remove(nums[i]); 
                list.remove(list.size()-1);
            }
        }
    }
}