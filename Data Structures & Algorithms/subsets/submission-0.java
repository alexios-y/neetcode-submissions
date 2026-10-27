class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> cur=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        dfs(nums,0, cur, res);
        return res;
    }

    public void dfs(int[] nums, int i, List<Integer> cur, List<List<Integer>> res){
        if(i >= nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        dfs(nums,i+1, cur, res);
        cur.remove(cur.size()-1);
        dfs(nums,i+1,cur,res);
    }
}
