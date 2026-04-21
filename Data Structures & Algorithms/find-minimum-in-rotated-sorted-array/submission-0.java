class Solution {
    public int findMin(int[] arr) {
        return Arrays.stream(arr).min().getAsInt();
    }
}
