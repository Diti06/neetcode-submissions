class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1 ; // left pointer
        int maxSpeed = 0 ; // right pointer
        int len = piles.length;
        for(int i =0 ; i < len ; i++){
            maxSpeed = Math.max(maxSpeed , piles[i]);
        }// we will get the max speed
         int result = maxSpeed ; // aa return krsu .
        
        while(minSpeed <= maxSpeed){
            int currentSpeed = (minSpeed + maxSpeed)/2 ;
            long totalTime = 0 ;
            for(int i : piles ){
                totalTime = totalTime + (i + currentSpeed - 1L) / currentSpeed; // current pile khata ketlo time lagse
            
            }

            if(totalTime <= h){
                result = currentSpeed;
                maxSpeed = currentSpeed - 1; // we moved to left half of the middle ele
            }else{
                minSpeed = currentSpeed + 1; // we move to right half of the middle ele 
            }
        }
        return result ;
    }
}
