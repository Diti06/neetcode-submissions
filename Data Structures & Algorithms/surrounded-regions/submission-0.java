class Solution {
    public void solve(char[][] board) {
        int rows = board.length ;
        int col = board[0].length;

        // safe gaurding all extreme endpoints of rows
        for(int i = 0 ; i < rows ; i++){
            if(board[i][0]== 'O') dfs(board , i , 0);//  0 X X X..
            if(board[i][col -1] == 'O') dfs(board , i , col -1); //..X X O
        }

        // safe gaurding all extreme col endpoints
        for(int j = 0 ; j < col ; j++){
            if(board[0][j] == 'O') dfs(board , 0 , j);
            if(board[rows -1][j] == 'O') dfs(board , rows-1 , j);
        }

        // visit each cell and if it is 'S' then convert it back to 'O'
        for(int i = 0 ; i < rows ; i++){
            for(int j= 0 ; j< col ; j++){
                if(board[i][j]== 'O'){
                    board[i][j] = 'X'; 
                }
                if(board[i][j]== 'S'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    public void dfs(char[][] board , int i , int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return ;
        }
        if(board[i][j] != 'O')return ;
        board[i][j] = 'S'; // we have marked it safe

        dfs(board , i-1 , j);
        dfs(board , i+1 , j);
        dfs(board , i ,j-1);
        dfs(board , i, j+1);
        
    }
}
