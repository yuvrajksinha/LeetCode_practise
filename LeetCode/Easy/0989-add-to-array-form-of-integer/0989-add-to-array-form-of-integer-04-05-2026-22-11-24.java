class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n=num.length,i=n-1;
        List<Integer> result = new ArrayList<>();
        while(i>=0||k>0){
            if(i>=0){
                k+=num[i--];
            }
            result.add(0,k%10);
            k/=10;
        }
        return result;
    }
}