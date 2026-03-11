class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backtracking(nums,0,new ArrayList<>(),lists);
        return lists;
    }
    public void backtracking(int[] nums,int index,List<Integer> list,List<List<Integer>> lists){
        lists.add(new ArrayList<>(list)); 
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            backtracking(nums,i+1,list,lists); 
            list.remove(list.size()-1);
        }
    }
}