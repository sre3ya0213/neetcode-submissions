class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix[0].length;
        int leftRow = 0;
        int rightRow = matrix.length-1;
        
        while(leftRow <= rightRow) {
            int midRow = leftRow + (rightRow-leftRow)/2;
            if(matrix[midRow][0] <= target && matrix[midRow][n-1] >= target) {
                int l=0;
                int r=n-1;
                while(l<=r) {
                    int mid = l + ((r-l)/2);
                    if(matrix[midRow][mid] == target) {
                        return true;
                    }
                    else if(matrix[midRow][mid] > target) {
                        r = mid-1;
                    }
                    else {
                        l = mid+1;
                    }
                }
                return false;
            }
            else if(matrix[midRow][0] > target){
                rightRow = midRow-1;
            }
            else {
                leftRow = midRow+1;
            }
        }

        return false;
    }
}
