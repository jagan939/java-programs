class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }
}

OUTPUT:
Input
nums =
[0,2,1,5,3,4]
Output
[0,1,2,4,5,3]
Expected
[0,1,2,4,5,3]
