class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> cur=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        dfs(nums,0,cur,res,target);
        return res;
    }

    public void dfs(int[] nums, int i, List<Integer> cur, List<List<Integer>> res, int target){
        if(target==0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(i>=nums.length || target<0){
            return;
        }

        
        cur.add(nums[i]);
        dfs(nums, i, cur,res,target-nums[i]);
        cur.remove(cur.size()-1);
        dfs(nums,i+1,cur,res,target);
    }
}
