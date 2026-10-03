class Solution {
    public int trap(int[] height) {
        int water=0;
        int l=0;
        int r=height.length-1;
        int lmax=height[l];
        int rmax=height[r];
        while(l<r){
            if(lmax<rmax){
                water=water+lmax-height[l];
                l++;
                lmax=Math.max(lmax,height[l]);
            }
            else{
                water=water+rmax-height[r];
                r--;
                rmax=Math.max(rmax,height[r]);
            }
        }

        return water;
    }
}
