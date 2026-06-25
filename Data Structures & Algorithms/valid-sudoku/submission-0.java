class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer , Set<Character> >rows = new HashMap<>();
        Map<Integer , Set<Character> >cols = new HashMap<>();
        Map<String , Set<Character> >squares = new HashMap<>();

        for(int r = 0 ; r < 9 ; r++){
            for(int c = 0 ; c <9 ; c++){

                if(board[r][c]== '.')continue; // if value is empty continue

                String squareKey = (r/3) + "," + (c/3); // sub square value 
                // (0,0)-> set(1,2,3..) (0,1) -> set(1,2,3..) ...
                // this will ensure that no duplicates occur in 3 x 3 square

                if(rows.computeIfAbsent(r , k ->new HashSet<>()).contains(board[r][c])
                // if first time che toh hashset create 
                //kri value insert kro ne pachi check kro k ee value che k nai set ma
                || cols.computeIfAbsent(c , k -> new HashSet<>()).contains(board[r][c])
                || squares.computeIfAbsent(squareKey , k -> new HashSet<>()).contains(board[r][c])){
                    return false;
                }  
                rows.get(r).add(board[r][c]); // agar value nathi set ma toh add kro
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);

            }
        }
        return true;
    }
}
