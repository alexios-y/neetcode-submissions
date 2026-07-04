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
    public TreeNode invertTree(TreeNode root) {
        return BFS(root);
    }

    TreeNode DFS(TreeNode root){
        //DFS:
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    TreeNode BFS(TreeNode root){
        if(root==null){
            return null;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode top=queue.poll();
            TreeNode tmp=top.left;
            top.left=top.right;
            top.right=tmp;
            if(top.left!=null) queue.offer(top.left);
            if(top.right!=null) queue.offer(top.right);
        }

        return root;
    }
}
