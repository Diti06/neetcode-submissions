/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node , Node > map = new HashMap<>();
    public Node cloneGraph(Node node) {

        if(node == null){
            return null;
        }
        if (map.containsKey(node)) return map.get(node);// this will avoid cycles

        Node clone = new Node(node.val); // if not present then we will create a copy 
        map.put(node , clone); // add this to hashmap 1->1'

        for(Node n : node.neighbors){
            
            clone.neighbors.add(cloneGraph(n)); // this will help in cloning as well as connecting it to its neighbors.    
        }

        return map.get(node);//1'

        
    }
}