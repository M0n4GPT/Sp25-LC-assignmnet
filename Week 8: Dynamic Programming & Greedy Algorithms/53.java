class Solution {
    public int maxSubArray(int[] nums) {
        int premax = 0, maxAns = nums[0];
        for (int x : nums) {
            premax = Math.max(premax + x, x);
            maxAns = Math.max(maxAns, premax);
        }
        return maxAns;     
    }
}
