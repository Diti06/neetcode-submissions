class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        // int counter= 0;
        int maxLen = 0;

        int start = 0 , end = 0 ;

        while(end < len){

            if(!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                
                end++;
                maxLen = Math.max(maxLen , end - start);
                
            }else{
                
                set.remove(s.charAt(start));
                start++;
                
            }
        }
        return maxLen;

    }
}
