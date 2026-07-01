/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> result = new ArrayList<>();
       Queue<TreeNode> q = new LinkedList<>();
       q.offer(root); // queue interface method . but for linkedlist
       // it adds the element to the end of the linked list 
       // it is similar to q.add() but it handles failure in different way ?

       while(!q.isEmpty()){
        TreeNode rightSide = null; // helps us remember the rightmost element in that level
        int qLen = q.size();
        
        for(int i = 0 ; i < qLen ; i++){
            TreeNode node = q.poll(); // queue interface method.
            // it removes the first element from the linkedlist;
            if(node != null){
                rightSide = node ;
                q.offer(node.left);// pela left node insert
                q.offer(node.right);// then right node

            }
            
        }// at the end of this we will have the rightmost node and the updated q
        if(rightSide != null){
                result.add(rightSide.val);// update kro list ne
            }
       }
      return result ;
    }


}
