class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String s : strs){
            res.append(s.length()).append('#').append(s);// 3#yay
        }
        return res.toString();

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0 ;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j)); 
            // we will get the int value of the length of the word
            i = j+1 ; // this now points to the starting char of the word.
            j = i+ length ; // this now points to next numeric position
            res.add(str.substring(i , j));
            i = j ;
        }
        return res ;

    }
}
