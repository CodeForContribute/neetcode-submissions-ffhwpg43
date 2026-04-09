class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        if(arr == null || arr.length == 0)return new ArrayList();
        int n = arr.length;
        Arrays.sort(arr);
        // -1,0,1,2,-1,-4
        // -4, -1, -1, 0, 1, 2
        List<List<Integer>>result = new ArrayList();
        for(int i = 0; i < n;i++){
            if(arr[i] > 0)break;
            if(i > 0 && arr[i] == arr[i-1])continue;
            twoSum(arr, i,result);
        }
        return result;
    }
    private void twoSum(int[]arr, int pos,List<List<Integer>>result){
        int left = pos+1, right = arr.length-1;
        while(left < right){
            int sum = arr[pos] + arr[left] + arr[right];
            if(sum > 0){
                right--;
            }else if(sum < 0)left++;
            else{
                result.add(Arrays.asList(arr[pos],arr[left],arr[right]));
                left++;right--;
                while(left < right && arr[left] == arr[left-1])left++;
            }
        }
    }
}
