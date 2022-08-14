import java.util.*;
public class Solution {
    public static int minSumPath(int[][] grid) {
    	// Write your code here.
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        int[][] memo = new int[m + 1][n + 1];
        return findPathSum(m, n, grid, memo);
    }
    public static int findPathSum(int m, int n, int[][] grid, int[][] memo) {
        if (m == 0 && n == 0) {
            return grid[0][0];
        }
        else if (m < 0|| n < 0) {
            return Integer.MAX_VALUE;
        }
        else if (memo[m][n] != 0) {
            return memo[m][n];
        }
        else {
            return memo[m][n] = grid[m][n] + Math.min(findPathSum(m-1, n, grid, memo), findPathSum(m, n-1, grid, memo)); 
        }
    }
}