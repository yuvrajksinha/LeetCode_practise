class Solution {
    public Map<Integer,Integer> memo = new HashMap<>();
    public String s;
    public int dp(int i){
        if(i==s.length()){ //index reach end of string
            return 1; //so 1 way to decode found
        }
        if(s.charAt(i)=='0'){ //char at index is '0', it can't create a letter or anything so return 0
            return 0;
        }
        if(i==s.length()-1){ //as the char is not '0' and i at last index, so decode give 1 way only
            return 1;
        }
        if(!memo.containsKey(i)){
            int answer = dp(i+1); //getting the decode for the rest of the string treating the index i as representing single character
            if(Integer.valueOf(s.substring(i,i+2))<=26){ //if the digit at i and i+1 makes ascii that is less than equal to 26
                answer+=dp(i+2); //we treat i and i+1 as representing a single character and get the decode from after that index
            }
            memo.put(i,answer); //and put this in answer
        }
        return memo.get(i);
    }
    public int numDecodings(String s) {
        this.s=s;
        return dp(0);
    }
}