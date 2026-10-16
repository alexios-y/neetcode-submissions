class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int l,r;

        l=0;
        r=rows-1;
        while(l<r){
            int mid = (l+r) /2;
            if(matrix[mid][cols-1]<target){
                l=mid+1;
            } else{
                r=mid;
            }
        }

        int t=l;

        l=0;
        r=cols-1;
        while(l<=r){
            int mid=(l+r) /2 ;
            if(matrix[t][mid]<target){
                l=mid+1;
            } else if(matrix[t][mid]>target){
                r=mid-1;
            } else return true;
        }
        return false;
    }
}
