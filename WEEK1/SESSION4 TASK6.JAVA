class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}
OUTPUT:
Input
nums =
[1,2,3,4]
Output
[1,3,6,10]
Expected
[1,3,6,10]
