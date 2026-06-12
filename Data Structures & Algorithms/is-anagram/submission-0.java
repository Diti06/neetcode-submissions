class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        Map<Character , Integer> hash1 = new HashMap<>();
        Map<Character , Integer> hash2 = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            hash1.put(s.charAt(i), hash1.getOrDefault(s.charAt(i),0)+1);
            hash2.put(t.charAt(i),hash2.getOrDefault(t.charAt(i),0)+1);
        }
        return hash1.equals(hash2);

    }
}
