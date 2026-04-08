class Solution {
    public int[] nums1,nums2;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        int m=nums1.length,n=nums2.length;
        int mainLength = m+n;
        if(mainLength%2!=0){ //if odd find n/2 of the main length
            return findK(mainLength/2,0,m-1,0,n-1);
        } else { //if even find n/2 and n/2-1 elements from the main length and take average
            return (double)(findK(mainLength/2,0,m-1,0,n-1)+findK((mainLength/2)-1,0,m-1,0,n-1))/2;
        }
    }
    public int findK(int k,int nums1Start,int nums1End,int nums2Start,int nums2End){
        if(nums1End<nums1Start){ //if nums1 is finished checking and the end goes beyond start
            return nums2[k-nums1Start]; //nums1Start removed elements from nums1 so k-number of elements already removed from 1
        } 
        if(nums2End<nums2Start){
            return nums1[k-nums2Start];
        }

        int nums1MidIndex = nums1Start+(nums1End-nums1Start)/2; //get mid index
        int nums2MidIndex = nums2Start+(nums2End-nums2Start)/2;

        int nums1MidVal = nums1[nums1MidIndex]; //get mid val
        int nums2MidVal = nums2[nums2MidIndex];

        if(nums1MidIndex+nums2MidIndex<k){ //if both the mid index is <k then we can for sure remove the index whose value is less as that will not be close to median
            if(nums1MidVal<nums2MidVal){ //as num1 mid val is less we remove till its mid and go ahead
                return findK(k,nums1MidIndex+1,nums1End,nums2Start,nums2End);
            } else { //vice versa
                return findK(k,nums1Start,nums1End,nums2MidIndex+1,nums2End);
            }
        } else { //now the indexes give >=k,so the larger part is too high to be near median 
            if(nums1MidVal<nums2MidVal){//so remove the larger valued mid from answers
                return findK(k,nums1Start,nums1End,nums2Start,nums2MidIndex-1);
            }
            else {
                return findK(k,nums1Start,nums1MidIndex-1,nums2Start,nums2End);
            }
        }
    }
}