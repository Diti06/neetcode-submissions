class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer> map = new HashMap<>();
        // (value , index)
        for(int i = 0 ; i < nums.length;i++){
            map.put(nums[i], i); // value , index
        }
        for(int i = 0 ; i < nums.length; i++){
            int difference = target - nums[i];

            if(map.containsKey(difference) && map.get(difference) != i){
                return new int[]{i, map.get(difference)};
            }
        }
        return new int[0];
    }
}
