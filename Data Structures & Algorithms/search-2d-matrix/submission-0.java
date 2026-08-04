class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix[0].length;
        for(int i=0;i<matrix.length;i++) {
            if(matrix[i][0] <= target && matrix[i][n-1] >= target) {
                int l=0;
                int r=n-1;
                while(l<=r) {
                    int mid = l + ((r-l)/2);
                    if(matrix[i][mid] == target) {
                        return true;
                    }
                    else if(matrix[i][mid] > target) {
                        r = mid-1;
                    }
                    else {
                        l = mid+1;
                    }
                }
            }
        }
        return false;
    }
}
