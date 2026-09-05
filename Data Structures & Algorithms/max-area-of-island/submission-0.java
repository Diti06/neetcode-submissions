class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0 ;
        }
        int maxArea = 0 ;

        for(int i = 0 ; i <grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j]== 1){
                    maxArea = Math.max(maxArea , dfs(grid , i ,j));
                }
            }
        }

        return maxArea ;
    }

    private int dfs(int[][] grid , int i , int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j]== 0){
            return 0 ;
        }
         
        grid[i][j] = 0 ; // marked as visited

        int totalArea = 0 ;

        int downArea = dfs(grid , i+1 , j);
        int upArea = dfs(grid , i-1 , j);
        int rightArea = dfs(grid ,i , j+1);
        int leftArea = dfs(grid , i , j-1);

        totalArea = 1 + downArea + upArea + rightArea + leftArea ;

        return totalArea;
    }
}
