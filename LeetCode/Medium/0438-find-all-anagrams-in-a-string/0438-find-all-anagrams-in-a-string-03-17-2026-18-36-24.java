class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int lenP=p.length(), lenS=s.length();
        if(lenS<lenP){return result;}
        int[] freqS = new int[26];
        int[] freqP = new int[26];
        for(int i=0;i<lenP;i++){
            freqP[p.charAt(i)-'a']++;
        }
        int left=0; //6
        for(int right=0;right<lenS;right++){ //8
            char rightChar = s.charAt(right);
            freqS[rightChar-'a']++;
            while(freqS[rightChar-'a']>freqP[rightChar-'a']){
                char leftChar = s.charAt(left);
                freqS[leftChar-'a']--;
                left++;
            }
            if((right-left+1)==lenP){
                result.add(left);
            }
        }
        return result;
    }
}