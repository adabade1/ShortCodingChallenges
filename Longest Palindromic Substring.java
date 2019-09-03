/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
*/


class Solution 
{
    String longestSubstr;
    public String longestPalindrome(String s) 
    {
        longestSubstr = "";
        //Null check and empty check
        if(s == null || s.length() == 0)
            return longestSubstr;
        /*
        Traverse each character and expand to check for palindrome
        */
        for(int i = 0 ; i < s.length() ; i++)
        {
            //Odd length palindrome
            checkPalindrome(i, i, s);
            //Even length palindrome
            checkPalindrome(i, i+1, s);
        }
        return longestSubstr;
    }
    
    private void checkPalindrome(int start, int end, String s)
    {
        /* Expand while start and end are equal*/
        while(end < s.length() && start >= 0 && s.charAt(start) == s.charAt(end))
        {
            end++;
            start--;
        }
        /* Check if the current longest substring is smaller than what we got from the above while loop*/
        if(s.substring(start+1,end).length() > longestSubstr.length())
        {
            longestSubstr = s.substring(start+1,end);
        }
    }
}