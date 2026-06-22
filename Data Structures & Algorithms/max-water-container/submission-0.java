class Solution {
    public int maxArea(int[] heights) {
        int result = 0 ;
        int l = 0 ;
        int r = heights.length -1;

        while( l < r){
            int area = Math.min(heights[l], heights[r]) * (r-l);
            result = Math.max(result, area);

            if(heights[l]> heights[r]){
                r--; // which ever is small we move that pointer.
            }else{
                l++;
            }

        }
        return result;
    }
}
