class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if(points == null || points.length == 0)return new int[][]{};
        int n = points.length;
        int left = 0, right = n-1;
        int pivot = n;
        while(pivot != k){
            pivot = partition(points,left, right);
            if(pivot < k){
                left = pivot+1;
            }else right = pivot-1;
        }
        //int[][]result = new int[k][2];
        return Arrays.copyOfRange(points,0,k);
        // return result;
    }

    private int partition(int[][]points, int left, int right){
        int pivotIdx = right;
        int distance = euclidean(points[pivotIdx]);
        int idx = left;
        for(int j = left; j < right; j++){
            if(euclidean(points[j]) <= distance){
                swap(points,idx,j);
                idx++;
            }
        }
        swap(points,idx,pivotIdx);
        return idx;
    }

    private void swap(int[][]points,int i, int j){
        int[]tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    private int euclidean(int[]point){
        return point[0] * point[0] + point[1] * point[1];
    }
}
