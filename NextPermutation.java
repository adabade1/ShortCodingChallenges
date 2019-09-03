/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 ? 1,3,2
3,2,1 ? 1,2,3
1,1,5 ? 1,5,1
*/

/*
1. Traverse from the end and find the first decreasing element, say min
2. Traverse from the end and get the next greater element than min and swap this number and min
3. Reverse the array elements after min+1 position till the end
4. return the array
*/

class Solution 
{
    public void nextPermutation(int[] nums) 
    {
        //Null check and empty check
        if(nums == null || nums.length == 0)
            return;
        int i = nums.length - 1;
        //Getting the first decreasing element
        for(i = nums.length - 1 ; i > 0 ; i--)
        {
            if(nums[i] > nums[i-1])
                break;
        }
        //Decrementing i because we are interested in the index of the smaller element and not the one next to it which is just i
        i--;
        //If i becomes -1 it means we did not get a decreasing number meaning the array is in descending order and the next permutation to this should be the first permutation i.e sorted in ascending order
        if(i < 0)
        {
            Arrays.sort(nums);
            return;
        }
        //Getting a number greater than nums[i], traversing from the end
        int j = nums.length - 1;
        for(j = nums.length - 1 ; j >= 0 ; j--)
        {
            if(nums[i] < nums[j])
                break;
        }
        swap(i, j, nums);
        reverse(i+1, nums.length - 1, nums);
    }
    
    private void swap(int i, int j, int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int i, int j, int[] nums)
    {
        while(i < j)
        {
            swap(i, j, nums);
            i++;
            j--;
        }
    }
}