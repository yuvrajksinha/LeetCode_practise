class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] answer = new int[n];

        //for left products apart from self
        left[0]=1; //as to the left of first element is nothing
        for(int i=1;i<n;i++){
            left[i]=left[i-1]*nums[i-1]; //this keeps left product upto i-1 element in i(not itself)
        }

        //for right products apart from self
        right[n-1]=1; //as to the right of last element is nothing
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]*nums[i+1];//right product upto i+1 element in i(not itself included)  
        }
        for(int i=0;i<n;i++){
            answer[i]=left[i]*right[i];
        }
        return answer;
    }
}