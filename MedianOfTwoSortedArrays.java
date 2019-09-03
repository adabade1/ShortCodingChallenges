/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/

class Solution 
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        double median = 0;
        //Null check
        if(nums1 == null || nums2 == null)
            return median;
        
        int[] merged = new int[nums1.length + nums2.length];
        int cnt = 0;
        int i = 0;  //for nums1
        int j = 0;  //for nums2
        
        //Merge two arrays, they are already sorted
        while(i < nums1.length && j < nums2.length)
        {
            if(nums1[i] <= nums2[j])
            {
                merged[cnt++] = nums1[i];
                i++;
            }
            else
            {
                merged[cnt++] = nums2[j];
                j++;
            }
        }
        
        while(i < nums1.length)
        {
            merged[cnt++] = nums1[i];
            i++;
        }
        
        while(j < nums2.length)
        {
            merged[cnt++] = nums2[j];
            j++;
        }
        //for odd length array, middle element itself is the median
        if(merged.length % 2 != 0)
            return merged[merged.length / 2];
        
        //for even length array, mean of the middle two elements is the overall median
        else
        {
            int mid1 = merged[merged.length / 2];
            int mid2 = merged[merged.length / 2 - 1];
            return (double)(mid1+mid2)/2;
        }
    }
}
