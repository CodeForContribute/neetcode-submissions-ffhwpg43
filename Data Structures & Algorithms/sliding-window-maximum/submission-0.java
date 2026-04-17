class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> dq = new LinkedList<>();
    int n = nums.length;
    int[] res = new int[n - k + 1];

    for (int i = 0; i < n; i++) {
        // Remove out of window
        if (!dq.isEmpty() && dq.peekFirst() == i - k) {
            dq.pollFirst();
        }

        // Maintain decreasing order
        while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
            dq.pollLast();
        }

        dq.offerLast(i);

        // Store result
        if (i >= k - 1) {
            res[i - k + 1] = nums[dq.peekFirst()];
        }
    }

    return res;
}
}


