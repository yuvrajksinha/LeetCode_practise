class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int lens1=s1.length(),lens2=s2.length();
        if(lens2<lens1){return false;}
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i=0;i<lens1;i++){
            freq1[s1.charAt(i)-'a']++;
        }
        int left=0;
        for(int right=0;right<lens2;right++){
            char rightChar = s2.charAt(right);
            freq2[rightChar-'a']++;
            while(freq2[rightChar-'a']>freq1[rightChar-'a']){
                char leftChar = s2.charAt(left);
                freq2[leftChar-'a']--;
                left++;
            }
            if((right-left+1)==lens1){
                return true;
            }
        }
        return false;
    }
}