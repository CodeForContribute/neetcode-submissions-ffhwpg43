class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        if(arr == null || arr.length == 0)return new ArrayList();
        List<List<Integer>>result = new ArrayList();
        Arrays.sort(arr);
        int n = arr.length;
        for(int i = 0; i < n && arr[i] <= 0;i++){
                if( i > 0 && arr[i] == arr[i-1])continue;
                twoSum(arr, i, result);
        }
        return result;
    }

    public void twoSum(int[]arr, int index, List<List<Integer>>result){
        int left = index + 1, right = arr.length - 1;
        while(left < right){
            int sum = arr[index] + arr[left] + arr[right];
            if(sum == 0){
                result.add(Arrays.asList(arr[index], arr[left], arr[right]));
                left++; right--;
                while(left < right && arr[left] == arr[left-1])left++;
            }else if(sum > 0)right--;
            else left++;
        }
    }
    // public void twoSum(int[]arr, int index, List<List<Integer>>result){
    //     int 
        // int left = index+1, right = arr.length-1;
        // while(left < right){
        //     int sum = arr[index] + arr[left] + arr[right];
        //     if(sum == 0){
        //         result.add(Arrays.asList(arr[index], arr[left], arr[right]));
        //         left++;right--;
        //         while(left < right && arr[left] == arr[left-1])left++;
        //     }else if(sum > 0)right--;
        //     else left++;
        // }
    // }
}
