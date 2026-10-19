class PrefixTree {
    static class TreeNode{
        TreeNode[] children=new TreeNode[26];
        boolean end;
    }

    TreeNode root;
    public PrefixTree() {
         root=new TreeNode();
    }

    public void insert(String word) {
        TreeNode cur=root;
        for(char c : word.toCharArray()){
            int idx=c-'a';
            if(cur.children[idx]==null){
                cur.children[idx]=new TreeNode();
            }
            cur=cur.children[idx];
        }
        cur.end=true;
    }

    public boolean search(String word) {
        TreeNode cur=root;
        for(char c : word.toCharArray()){
            int idx=c-'a';
            if(cur.children[idx]==null){
                return false;
            }
            cur=cur.children[idx];
        }
        return cur.end==true;        
    }

    public boolean startsWith(String prefix) {
        TreeNode cur=root;
        for(char c : prefix.toCharArray()){
            int idx=c-'a';
            if(cur.children[idx]==null){
                return false;
            }
            cur=cur.children[idx];
        }
        return true;  
    }
}
