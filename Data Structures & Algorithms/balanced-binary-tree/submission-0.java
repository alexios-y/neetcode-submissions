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
    public boolean isBalanced(TreeNode root) {
        boolean[] res=new boolean[1];
        res[0]=true;
        dfs(root, res);
        return res[0];
    }

    int dfs(TreeNode node, boolean[] res){
        if(node ==null){
            return 0;
        }

        int hl=dfs(node.left, res);
        int hr=dfs(node.right, res);
        if(!(Math.abs(hl-hr)<=1)){
            res[0]=false; 
        }

        return 1+Math.max(hl,hr);
    }
}
