class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        int maxSum = nums[0];
        int curMax = 0;

        int minSum = nums[0];
        int curMin = 0;

        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);

            totalSum += num;
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}

OUTPUT:
Input
nums =
[1,-2,3,-2]
Output
3
Expected
3
