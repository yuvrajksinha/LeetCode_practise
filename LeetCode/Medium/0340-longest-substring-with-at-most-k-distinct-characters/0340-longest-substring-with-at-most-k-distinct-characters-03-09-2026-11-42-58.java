//1<=s.length<=5*10^4
//1<=k<=50
//sliding window
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) { // right = 4 left = 3
        if(k==0){
            return 0;
        }
        Map<Character,Integer> freq = new HashMap<>(); // b->1 a->1 len(freq)=2
        int left=0,maxLength=0;
        for(int right=0;right<s.length();right++){
            //add right element to the window
            char rightChar = s.charAt(right);
            freq.put(rightChar,freq.getOrDefault(rightChar,0)+1);
            while(freq.size()>k){
                //remove the left element from window
                char leftChar = s.charAt(left);
                freq.put(leftChar,freq.get(leftChar)-1);
                if(freq.get(leftChar)==0){
                    freq.remove(leftChar);
                }
                left++;
            }
            maxLength = Math.max(maxLength,right-left+1); // maxLength => 3
        }
        return maxLength; // 3
    }
}