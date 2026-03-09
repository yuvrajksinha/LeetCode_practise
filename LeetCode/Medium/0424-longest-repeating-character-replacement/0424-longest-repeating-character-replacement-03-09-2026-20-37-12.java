class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];  
        int left=0,maxFreq=0,maxLength=0;  
        for(int right=0;right<s.length();right++){
            char rightChar = s.charAt(right);
            freq[rightChar-'A']++;
            maxFreq = Math.max(maxFreq,freq[rightChar-'A']); 
            while((right-left+1)-maxFreq>k){  
                char leftChar = s.charAt(left);
                freq[leftChar-'A']--;
                left++; 
            }
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}