class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> result = new HashMap<>();
        for(String s : strs){
            int[] count = new int[26]; // for alphabets a-z
            for(char c : s.toCharArray()){
                count[c- 'a']++ ;
                 // suppose string "jar" count[j-a] = count[10]++
            }
            String key = Arrays.toString(count); // this becomes key in the hashmap

            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(s); // this will add string against the key in the hashmap
        }
        return new ArrayList<>(result.values());
    }
}
