/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

/*
1. keep three pointers i, i+1 and nums.length - 1
2. maintain a variable for min difference 
*/

class Solution
{
    public int threeSumClosest(int[] nums, int target){
        if(nums == null || nums.length == 0 || nums.length < 3)
            return 0;
        int minDiff = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 2 ; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k)
            {
                int temp = nums[i] + nums[j] + nums[k];
                if(temp > target)
                   k--;
                else if(temp < target)
                    j++;
                else if((temp == target))
                    return target;
                if(Math.abs(temp - target) < Math.abs(minDiff - target))
                    minDiff = temp;
            }     
        }
        return minDiff;
    }
}