class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        backtracking(candidates,target,0,new ArrayList<>(),lists);
        return lists;
    }
    public void backtracking(int[] candidates,int remaining,int index,List<Integer> list,List<List<Integer>> lists){
        if(remaining==0){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(remaining<0){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            list.add(candidates[i]);
            backtracking(candidates,remaining-candidates[i],i,list,lists);
            list.remove(list.size()-1);
        }
    }
}