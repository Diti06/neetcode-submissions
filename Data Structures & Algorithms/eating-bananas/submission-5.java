class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1 ;
        int right = Arrays.stream(piles).max().getAsInt();

        int result = right ;

        while(left < right){
            int mid = left + (right - left) /2 ;

            long totalTime = 0 ;
            for(int p : piles){
                totalTime += Math.ceil((double)p / mid);

            }
            if(totalTime <= h){
                result = mid ;
                right = mid ;
            }else{
                left = mid +1 ;
            }

        }
        return result ;
        
    }
}
