/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
*/

class Solution 
{
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        //Null check
        if(prerequisites == null)
            return false;
        
        //Empty check
        if(prerequisites.length == 0 || prerequisites[0].length == 0)
            return false;
          
        //Creating a numCourses X numCourses matrix to track the graph
        int[][] graph = new int[numCourses][numCourses];
        
        //Creating an array to store the indegree of every vertex
        int[] incoming = new int[numCourses];
        
        for(int[] row : prerequisites)
        {
            if(graph[row[1]][row[0]] == 0) 
                incoming[row[0]]++;
             graph[row[1]][row[0]] = 1;
        }
        
        //Creating a queue to store vertices which do not have any indegree; meaning that course can be taken next
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0 ; i < incoming.length ; i++)
        {
            if(incoming[i] == 0)
                q.offer(i);
        }
        
        while(!q.isEmpty())
        {
            int course = q.poll();
            count++;
            for(int i = 0 ; i < graph[0].length ; i++)
            {
                //Check for dependency and resolve it by adding in the queue
                if(graph[course][i] != 0)
                {
                    if(--incoming[i] == 0)
                        q.offer(i);
                }
            }
        }
        //Return true only if all courses are taken
        return count == numCourses;
    }
}