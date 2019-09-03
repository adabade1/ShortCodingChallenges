/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

*/

/*
1. Traverse the matrix 
2. if '1' , numIslands++, recursively check for connected 1's and make them '0'
*/

class Solution 
{
    /*
    This method counts the number of islands in a given 2d matrix.
    */
    public int numIslands(char[][] grid) 
    {
        //Null check and empty check
        if(grid == null || grid.length == 0)
            return 0;
        int numIslands = 0;
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                if(grid[i][j] == '1')
                {
                    numIslands++;
                    countIsland(i, j, grid);
                }
            }
        }
        return numIslands;
    }
    
    /*
    This method makes the 1's that are surrounded by '1' as '0' so as to count them as one island.
    */
    private void countIsland(int i, int j, char[][] grid)
    {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        countIsland(i+1, j, grid);
        countIsland(i-1, j, grid);
        countIsland(i, j+1, grid);
        countIsland(i, j-1, grid);
    }
}