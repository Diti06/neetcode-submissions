class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer , Integer > count = new HashMap<>();

        List<Integer>[] freq = new List[nums.length +1];
        // for each number in nums its frequency can range from 0 to nums.length 
        //eg [3,3,3,3] freq of 3 is 4 thus freq[4]= 3.

        for(int i =0 ; i < freq.length ; i++){
            freq[i] = new ArrayList<>();
        } 
        
        for(int n : nums){
            count.put(n , count.getOrDefault(n,0)+1);
        }// we will get freq of each number present in nums

        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
            // we are filling the freq list 
        }

        int[] res = new int[k];
        int index = 0 ;

        for(int i = freq.length -1 ; i > 0 ; i--){
            for(int n : freq[i]){
                res[index++]= n;
                if(index == k){
                    return res;
                }
            }
        }

        return res;
    }
}
