class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(candidates,0,target,new ArrayList<>(),combinations);
        return combinations;
    }
    public void backtrack(int[] candidates, int index,int remaining,List<Integer> combination,List<List<Integer>> combinations){
        if(remaining==0){
            combinations.add(new ArrayList<>(combination));
            return;
        }
        if(remaining<0){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i!=index && candidates[i]==candidates[i-1]){
                continue;
            }
            combination.add(candidates[i]);
            backtrack(candidates,i+1,remaining-candidates[i],combination,combinations);
            combination.remove(combination.size()-1);
        }
    }
}