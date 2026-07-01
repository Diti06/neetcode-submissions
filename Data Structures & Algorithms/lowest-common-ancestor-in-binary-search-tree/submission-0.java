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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while(current != null){
            if(current.val< p.val && current.val < q.val){// banne mota che toh right side move krsu
                current = current.right;
            }
            else if(current.val > p.val && current.val > q.val){// banne nana che toh left subtree ma hse
                current = current.left;
            }
            else{
                return current ; // aa j diverging point che toh aa j lca thyu
            }
        }
        return null ;
    }
}
