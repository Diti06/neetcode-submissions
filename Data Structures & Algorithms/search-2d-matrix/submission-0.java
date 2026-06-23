class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[rows-1].length;
        int top = 0 ;
        int bot = rows -1;
        
        while(top <= bot){
            int mid = (top+ bot)/2;
            if(matrix[mid][cols-1] < target){
            top = mid+1;
            }else if(matrix[mid][0] > target){
                bot = mid -1 ;
            }
            else{
                break;
            }
        }
        
        if(!(top <= bot)){
            return false;
        }
        int mid = (top+bot)/2;
        int l = 0 ; 
        int r = cols-1;
        while(l<=r){
            int m = (l+r)/2;
            if(target > matrix[mid][m]){
                l = m+1 ;
            }else if( target < matrix[mid][m]){
                r = m-1 ;
            }else{
                return true ;
            }
        }
        return false;
    }
}
