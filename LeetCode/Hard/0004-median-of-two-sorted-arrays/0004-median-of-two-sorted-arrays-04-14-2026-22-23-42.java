class Solution {
    private int[] nums1,nums2;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        int m=nums1.length,n=nums2.length;
        int totalLen=m+n;
        if(totalLen%2!=0){
            return searchForK(totalLen/2,0,m-1,0,n-1); 
        } else { 
            return (double)(searchForK(totalLen/2,0,m-1,0,n-1)+searchForK((totalLen/2)-1,0,m-1,0,n-1))/2;
        }
    }
    private int searchForK(int k,int nums1Start,int nums1End,int nums2Start,int nums2End){
        if(nums1End<nums1Start){ 
            return nums2[k-nums1Start]; 
        }
        if(nums2End<nums2Start){ 
            return nums1[k-nums2Start]; 
        }

        int nums1MidIndex = nums1Start+(nums1End-nums1Start)/2; 
        int nums2MidIndex = nums2Start+(nums2End-nums2Start)/2; 

        int nums1MidVal = nums1[nums1MidIndex]; 
        int nums2MidVal = nums2[nums2MidIndex]; 

        if(nums1MidIndex+nums2MidIndex<k){ 
            if(nums1MidVal<nums2MidVal){ 
                return searchForK(k,nums1MidIndex+1,nums1End,nums2Start,nums2End);
            } else { 
                return searchForK(k,nums1Start,nums1End,nums2MidIndex+1,nums2End);
            }
        } else { 
            if(nums1MidVal<nums2MidVal){  
                return searchForK(k,nums1Start,nums1End,nums2Start,nums2MidIndex-1); 
            } else { 
                return searchForK(k,nums1Start,nums1MidIndex-1,nums2Start,nums2End); 
            }
        }
    }
}