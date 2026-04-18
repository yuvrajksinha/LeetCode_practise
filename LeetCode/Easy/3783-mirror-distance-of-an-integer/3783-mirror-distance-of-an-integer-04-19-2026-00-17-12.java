class Solution {
    public int mirrorDistance(int n) {
        int temp = n,reversedNumber=0;
        while(temp!=0){
            int lastDigit = temp%10;
            reversedNumber = reversedNumber*10+lastDigit;
            temp/=10;
        }
        return Math.abs(n-reversedNumber);
    }
}